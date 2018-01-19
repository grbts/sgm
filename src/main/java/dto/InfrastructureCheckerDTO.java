package dto;

import auxillary.jsonhandler.deserializer.InfrastructureCheckerDTODeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import domain.Elements;

@JsonDeserialize(using = InfrastructureCheckerDTODeserializer.class)
public class InfrastructureCheckerDTO {
    Double version;
    String generator;
    Elements elements;

    public InfrastructureCheckerDTO(Double version, String generator, Elements elements) {
        this.version = version;
        this.generator = generator;
        this.elements = elements;
    }

    public InfrastructureCheckerDTO() {
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }
}
