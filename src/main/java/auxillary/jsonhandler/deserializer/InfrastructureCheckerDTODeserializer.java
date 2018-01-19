package auxillary.jsonhandler.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import domain.Elements;
import domain.Tags;
import dto.InfrastructureCheckerDTO;

import java.io.IOException;

public class InfrastructureCheckerDTODeserializer extends StdDeserializer<InfrastructureCheckerDTO> {

    public InfrastructureCheckerDTODeserializer() {
        this(null);
    }

    public InfrastructureCheckerDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public InfrastructureCheckerDTO deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode infrastructureCheckerNode = jp.getCodec().readTree(jp);

        Tags tags = new Tags();
        tags.setTotal(infrastructureCheckerNode.path("elements").get(0).get("tags").get("total").asInt());

        Elements elements = new Elements();
        elements.setTags(tags);
        elements.setId(infrastructureCheckerNode.get("elements").get(0).get("id").intValue());
        elements.setType(infrastructureCheckerNode.get("elements").get(0).get("type").textValue());


        InfrastructureCheckerDTO infrastructureCheckerDTO = new InfrastructureCheckerDTO();
        infrastructureCheckerDTO.setVersion(infrastructureCheckerNode.path("version").asDouble());
        infrastructureCheckerDTO.setGenerator(infrastructureCheckerNode.get("generator").textValue());
        infrastructureCheckerDTO.setElements(elements);

        return infrastructureCheckerDTO;
    }
}
