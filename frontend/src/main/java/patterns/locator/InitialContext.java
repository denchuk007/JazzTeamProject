package patterns.locator;

public class InitialContext {
    public Object lookup(String name)
    {
        if (name.equalsIgnoreCase("EmailService")) {
            return new EmailService();
        }
        else if (name.equalsIgnoreCase("SMSService")) {
            return new SMSService();
        }
        return null;
    }
}
