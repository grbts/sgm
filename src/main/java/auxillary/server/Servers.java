package auxillary.server;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Servers {


    public static URI getActiveServer() throws URISyntaxException {

        List<URI> serversList = new ArrayList<URI>() {
            {
                add(new URI("http://overpass-api.de/api/interpreter"));
                add(new URI("http://overpass.osm.rambler.ru/cgi/interpreter"));
            }
        };

        URI server = serversList.stream().filter(s -> hostAvailabilityCheck(s.getHost())).findFirst().orElse(null);
        assert server != null;
        return server;
    }

    private static boolean hostAvailabilityCheck(String address) {
        try (Socket s = new Socket(address, 80)) {
            s.close();
            return true;
        } catch (IOException ex) {
            ex.getMessage();
        }
        return false;
    }
}