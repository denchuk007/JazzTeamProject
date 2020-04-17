package calculator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(GetUserServlet.class.getName());
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "x";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inputLine = request.getParameter("inputValue").trim();
            inputValueVerification(inputLine);
            Pattern pattern = Pattern.compile("\\d+|[+\\-x/]");
            Matcher matcher = pattern.matcher(inputLine);
            double firstValue = Double.parseDouble(getValueFromMatcher(inputLine, matcher));
            String operation = getValueFromMatcher(inputLine, matcher);
            double secondValue = Double.parseDouble(getValueFromMatcher(inputLine, matcher));
            response.setContentType("text/plain");
            dividingByZeroVerification(secondValue, operation);
            String result = String.valueOf(getResult(firstValue, secondValue, operation));
            response.getWriter().write(result);
        } catch (DividingByZeroException | ExpressionNotFoundException | IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            response.getWriter().write(e.getMessage());
        }
    }

    private void dividingByZeroVerification(double secondValue, String operation) throws DividingByZeroException {
        if (secondValue == 0 && operation.equals(DIVIDE)) {
            throw new DividingByZeroException("Dividing by zero");
        }
    }

    private String getValueFromMatcher(String inputLine, Matcher matcher) throws ExpressionNotFoundException {
        if (matcher.find()) {
            return inputLine.substring(matcher.start(), matcher.end());
        }
        throw new ExpressionNotFoundException("Input line was not correct format");
    }

    private void inputValueVerification(String inputLine) throws ExpressionNotFoundException {
        Pattern pattern = Pattern.compile("^\\d+[+\\-x/]\\d+$");
        Matcher matcher = pattern.matcher(inputLine);
        if (!matcher.find()) {
            throw new ExpressionNotFoundException("Input line was not correct format");
        }
    }

    private double getResult(double firstValue, double secondValue, String operation) {
        double resultValue;
        switch (operation) {
            case PLUS:
                resultValue = firstValue + secondValue;
                break;
            case MINUS:
                resultValue = firstValue - secondValue;
                break;
            case MULTIPLY:
                resultValue = firstValue * secondValue;
                break;
            case DIVIDE:
                resultValue = firstValue / secondValue;
                break;
            default:
                resultValue = 0;
                break;
        }
        return resultValue;
    }
}
