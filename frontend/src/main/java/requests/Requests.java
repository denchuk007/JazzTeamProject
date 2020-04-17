package requests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Requests {

    public HttpURLConnection getResponseFromGetRequest(String accessToken) throws IOException, ExpressionNotFoundException {
        URL url = new URL(Constants.FILES_URL + Constants.API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.addRequestProperty("Accept", "application/json");
        connection.addRequestProperty("Authorization", "Bearer " + accessToken);
        connection.setRequestMethod("GET");
        return connection;
    }

    public HttpURLConnection getResponseFromPostRequest(String accessToken) throws IOException {
        URL url = new URL(Constants.FILES_URL + Constants.API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.addRequestProperty("Authorization", "Bearer " + accessToken);
        connection.addRequestProperty("Accept", "application/json");
        connection.addRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setFixedLengthStreamingMode(0);
        connection.setDoOutput(true);
        return connection;
    }

    public String getFileIdFromPostRequest(String accessToken) throws IOException, ExpressionNotFoundException {
        return getFileIdFromInputStream(getResponseFromPostRequest(accessToken).getInputStream());
    }

    public CloseableHttpResponse getResponseFromPutRequest(String accessToken, String fileId) throws IOException, ExpressionNotFoundException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch(new URI(Constants.FILES_URL + fileId + Constants.API_KEY));
        httpPatch.addHeader("Authorization", "Bearer " + accessToken);
        httpPatch.addHeader("Accept", "application/json");
        httpPatch.addHeader("Content-Type", "application/json");
        return httpClient.execute(httpPatch);
    }

    public HttpURLConnection getResponseFromDeleteRequest(String accessToken, String fileId) throws IOException, ExpressionNotFoundException {
        URL url = new URL(Constants.FILES_URL + fileId + Constants.API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.addRequestProperty("Accept", "application/json");
        connection.addRequestProperty("Authorization", "Bearer " + accessToken);
        connection.setRequestMethod("DELETE");
        connection.connect();
        return connection;
    }

    public String getAccessToken() throws IOException, ExpressionNotFoundException {
        String url = Constants.ACCESS_TOKEN_URL;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.addRequestProperty("content-type", "application/x-www-form-urlencoded");
        connection.addRequestProperty("user-agent", "google-oauth-playground");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        byte[] out = Constants.ACCESS_TOKEN_DATA.getBytes();
        writeToOutputStream(connection, out);
        String connectionResponse = getDataFromInputStream(connection.getInputStream());
        Pattern pattern = Pattern.compile("\"access_token\":\\s\".+\"");
        Matcher matcher = pattern.matcher(connectionResponse);
        if (matcher.find()) {
            return connectionResponse.substring(matcher.start() + 17, matcher.end() - 1);
        }
        throw new ExpressionNotFoundException("Expression not found");
    }

    private String getFileIdFromInputStream(InputStream inputStream) throws IOException, ExpressionNotFoundException {
        String connectionResponse = getDataFromInputStream(inputStream);
        Pattern pattern = Pattern.compile("\"id\":\\s\".+\"");
        Matcher matcher = pattern.matcher(connectionResponse);
        if (matcher.find()) {
            return "/" + connectionResponse.substring(matcher.start() + 7, matcher.end() - 1);
        }
        throw new ExpressionNotFoundException("Expression not found");
    }

    private void writeToOutputStream(HttpURLConnection connection, byte[] out) throws IOException {
        connection.setFixedLengthStreamingMode(out.length);
        connection.connect();
        try (OutputStream os = connection.getOutputStream()) {
            os.write(out);
        }
    }

    private String getDataFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            stringBuilder.append((char)bufferedReader.read());
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}
