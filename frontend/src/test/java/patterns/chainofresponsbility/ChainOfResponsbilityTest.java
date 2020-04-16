package patterns.chainofresponsbility;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import patterns.chainofresponsibility.*;

public class ChainOfResponsbilityTest {

    private static Server server;

    @BeforeClass
    public static void initialize() {
        server = new Server();
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());
        server.register("admin@example.com", "admin_pass");
        server.setMiddleware(middleware);
    }

    @Test
    public void correctLogIn() {
        String email = "admin@example.com";
        String password = "admin_pass";
        Assert.assertTrue(server.logIn(email, password));
    }

    @Test
    public void incorrectLogInWithWrongPassword() {
        String email = "admi@example.com";
        String password = "user_pass";
        Assert.assertFalse(server.logIn(email, password));
    }

}
