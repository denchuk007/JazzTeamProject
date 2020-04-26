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
    public void getResponseFromGetRequest() throws IOException {
        Assert.assertEquals(200, request.getResponseFromRequest(Constants.FILES_API_KEY_URL,
                "GET", accessToken).getResponseCode());
    }

    @Test
    public void getResponseFromPostRequest() throws IOException {
        Assert.assertEquals(200, request.getResponseFromRequest(Constants.FILES_API_KEY_URL,
                "POST", accessToken).getResponseCode());
    }

    @Test
    public void getResponseFromPutRequest() throws IOException, ExpressionNotFoundException, URISyntaxException {
        Assert.assertEquals(200, request.getResponseFromRequest(request.getFileId(accessToken),
                accessToken).getStatusLine().getStatusCode());
    }

    @Test
    public void getResponseFromDeleteRequest() throws IOException, ExpressionNotFoundException {
        String fileId = request.getFileId(accessToken);
        String url = Constants.FILES_URL + fileId + Constants.API_KEY;
        Assert.assertEquals(204, request.getResponseFromRequest(url, "DELETE",
                accessToken).getResponseCode());
    }

    @Test
    public void getResponseFromGetRequestWithIncorrectAccessToken() throws IOException {
        Assert.assertEquals(401, request.getResponseFromRequest(Constants.FILES_API_KEY_URL,
                "GET", "").getResponseCode());
    }

    @Test
    public void getResponseFromGetRequestWithNullAccessToken() throws IOException {
        Assert.assertEquals(401, request.getResponseFromRequest(Constants.FILES_API_KEY_URL,
                "GET", null).getResponseCode());
    }

    @Test
    public void getResponseFromDeleteRequestWithIncorrectFileId() throws IOException {
        Assert.assertEquals(404, request.getResponseFromRequest(Constants.FILES_API_KEY_URL,
                "DELETE", accessToken).getResponseCode());
    }
}