package patterns.chainofresponsibility;

public class RoleCheckMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            return true;
        }
        return checkNext(email, password);
    }
}