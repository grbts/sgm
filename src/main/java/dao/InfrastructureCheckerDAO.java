package dao;

import auxillary.server.ActiveServer;
import auxillary.httpconnector.HTTPConnector;
import auxillary.httpconnector.RequestMethod;
import auxillary.reader.FileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.InfrastructureCheckerDTO;
import org.apache.http.Header;

import java.io.IOException;
import java.net.URISyntaxException;

public class InfrastructureCheckerDAO {

    public  InfrastructureCheckerDTO getInfrastructureInformation() throws IOException {

        FileReader fileReader = new FileReader();
        String fileName = "InfrastructureInformationQuery.txt";
        String infrastructureInformationQuery = fileReader.getFile(fileName);

        HTTPConnector httpConnector = new HTTPConnector();
        String responseBody = null;
        try {
            responseBody = httpConnector.sendQuery(ActiveServer.getActiveServer(),
                    new Header[]{}, infrastructureInformationQuery, RequestMethod.POST);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, InfrastructureCheckerDTO.class);
    }


}
