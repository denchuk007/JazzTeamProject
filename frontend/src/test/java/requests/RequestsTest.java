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
        Assert.assertEquals(request.getResponseFromRequest(Constants.FILES_API_KEY_URL,"GET",
                accessToken).getResponseCode(), 200);
    }

    @Test
    public void getResponseFromPostRequest() throws IOException {
        Assert.assertEquals(request.getResponseFromRequest(Constants.FILES_API_KEY_URL,"POST",
                accessToken).getResponseCode(), 200);
    }

    @Test
    public void getResponseFromPutRequest() throws IOException, URISyntaxException, ExpressionNotFoundException {
        Assert.assertEquals(request.getResponseFromRequest(request.getFileId(accessToken),
                accessToken).getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void getResponseFromDeleteRequest() throws IOException, ExpressionNotFoundException {
        String fileId = request.getFileId(accessToken);
        String url = Constants.FILES_URL + fileId + Constants.API_KEY;
        Assert.assertEquals(request.getResponseFromRequest(url, "DELETE",
                accessToken).getResponseCode(), 204);
    }

    @Test
    public void getResponseFromGetRequestWithIncorrectAccessToken() throws IOException {
        Assert.assertEquals(request.getResponseFromRequest(Constants.FILES_API_KEY_URL, "GET",
                "").getResponseCode(), 401);
    }

    @Test
    public void getResponseFromGetRequestWithNullAccessToken() throws IOException {
        Assert.assertEquals(request.getResponseFromRequest(Constants.FILES_API_KEY_URL, "GET",
                null).getResponseCode(), 401);
    }

    @Test
    public void getResponseFromDeleteRequestWithIncorrectFileId() throws IOException {
        Assert.assertEquals(request.getResponseFromRequest(Constants.FILES_API_KEY_URL,
                "DELETE", accessToken).getResponseCode(), 404);
    }
}