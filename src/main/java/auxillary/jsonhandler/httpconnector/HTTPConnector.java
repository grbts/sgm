package auxillary.jsonhandler.httpconnector;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class HTTPConnector {

    public String sendQuery(URI uri, Header[] headers, String body, RequestMethod requestMethod) {

        HttpClient httpClient = HttpClientBuilder.create().build();
        String responseBody = "";
        try {

            HttpUriRequest httpUriRequest;

            switch (requestMethod) {
                case GET:
                    HttpGet httpGetRequest = new HttpGet(uri);
                    httpGetRequest.setHeaders(headers);
                    httpUriRequest = httpGetRequest;
                    break;

                case POST:
                    HttpPost httpPostRequest = new HttpPost(uri);
                    httpPostRequest.setHeaders(headers);
                    HttpEntity httpEntity = new StringEntity(body);
                    httpPostRequest.setEntity(httpEntity);
                    httpUriRequest = httpPostRequest;
                    break;

                default:
                    throw new IllegalArgumentException("Illegal argument: " + requestMethod);
            }

            HttpResponse httpResponse = httpClient.execute(httpUriRequest);
            responseBody = responseBodyExtractor(httpResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    private String responseBodyExtractor(HttpResponse httpResponse) throws IOException {

        String line;
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(httpResponse.getEntity().getContent()));

        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}