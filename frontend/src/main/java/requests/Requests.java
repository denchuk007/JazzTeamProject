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

    private static final String APPLICATION_JSON = "application/json";

    public HttpURLConnection getResponseFromRequest(String stringUrl, String requestMethod, String accessToken)
            throws IOException {
        URL url = new URL(stringUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.addRequestProperty("Accept", APPLICATION_JSON);
        connection.addRequestProperty("Authorization", "Bearer " + accessToken);
        connection.setRequestMethod(requestMethod);
        if (requestMethod.equals("POST")) {
            connection.addRequestProperty("Content-Type", APPLICATION_JSON);
            connection.setDoOutput(true);
            connection.setFixedLengthStreamingMode(0);
        }
        return connection;
    }

    public CloseableHttpResponse getResponseFromRequest(String fileId, String accessToken)
            throws IOException, URISyntaxException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPatch httpPatch = new HttpPatch(new URI(Constants.FILES_URL + fileId + Constants.API_KEY));
            httpPatch.addHeader("Authorization", "Bearer " + accessToken);
            httpPatch.addHeader("Accept", APPLICATION_JSON);
            httpPatch.addHeader("Content-Type", APPLICATION_JSON);
            return httpClient.execute(httpPatch);
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    public String getFileId(String accessToken) throws IOException, ExpressionNotFoundException {
        return getFileIdFromInputStream(getResponseFromRequest(Constants.FILES_API_KEY_URL,
                "POST", accessToken).getInputStream());
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
            String accessToken = connectionResponse.substring(matcher.start(), matcher.end() - 1);
            return accessToken.substring(accessToken.lastIndexOf('\"') + 1);
        }
        throw new ExpressionNotFoundException("Expression not found");
    }

    private String getFileIdFromInputStream(InputStream inputStream) throws IOException, ExpressionNotFoundException {
        String connectionResponse = getDataFromInputStream(inputStream);
        Pattern pattern = Pattern.compile("\"id\":\\s\".+\"");
        Matcher matcher = pattern.matcher(connectionResponse);
        if (matcher.find()) {
            String fileId = connectionResponse.substring(matcher.start(), matcher.end() - 1);
            return "/" + fileId.substring(fileId.lastIndexOf('\"') + 1);
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
            stringBuilder.append((char) bufferedReader.read());
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}
