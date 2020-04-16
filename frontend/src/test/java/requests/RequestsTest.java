package requests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class RequestsTest {

    private static Requests request;
    private static String accessToken;

    @BeforeClass
    public static void initialize() throws IOException, ExpressionNotFoundException {
        request = new Requests();
        accessToken = request.getAccessToken();
    }

    @Test
    public void getResponseFromGetRequest() throws IOException, ExpressionNotFoundException {
        Assert.assertEquals(request.getResponseFromGetRequest(accessToken).getResponseCode(), 200);
    }

    @Test
    public void getResponseFromPostRequest() throws IOException {
        Assert.assertEquals(request.getResponseFromPostRequest(accessToken).getResponseCode(), 200);
    }

    @Test
    public void getResponseFromPutRequest() throws IOException, ExpressionNotFoundException, URISyntaxException {
        Assert.assertEquals(request.getResponseFromPutRequest(accessToken,
                request.getFileIdFromPostRequest(accessToken)).getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void getResponseFromDeleteRequest() throws IOException, ExpressionNotFoundException {
        Assert.assertEquals(request.getResponseFromDeleteRequest(accessToken,
                request.getFileIdFromPostRequest(accessToken)).getResponseCode(), 204);
    }
}