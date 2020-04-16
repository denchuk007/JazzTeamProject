package patterns.chainofresponsibility;

public class RoleCheckMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello admin");
            return true;
        }
        System.out.println("User not found");
        return checkNext(email, password);
    }
}