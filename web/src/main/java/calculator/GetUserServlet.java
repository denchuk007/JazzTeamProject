package calculator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "x";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String inputLine = request.getParameter("inputValue").trim();
            inputValueVerification(inputLine);
            List<String> digits = new ArrayList<>(Arrays.asList(inputLine.split("[-+/x]")));
            List<String> operations = new ArrayList<>(Arrays.asList(inputLine.split("\\d+\\.\\d+|\\d+")));
            response.getWriter().write(String.valueOf(getResult(operations, digits)));
        } catch (ExpressionNotFoundException | DividingByZeroException e) {
            response.getWriter().write(e.getMessage());
        }
    }

    public String getResult(List<String> operations, List<String> digits)
            throws ExpressionNotFoundException, DividingByZeroException {
        if (minusInStartOfInputValue(operations)) {
            digits.remove(0);
            digits.set(0, MINUS + digits.get(0));
        }
        operations.remove(0);
        while (!operations.isEmpty()) {
            int index = getIndexAndResult(operations, digits).first;
            double result = getIndexAndResult(operations, digits).second;
            digits.set(index, String.valueOf(result));
            digits.remove(index + 1);
            operations.remove(index);
        }
        return digits.get(0);
    }

    private boolean isMultiplyOrDividingOperation(List<String> operations) {
        for (String s : operations) {
            if (s.equals(MULTIPLY) || s.equals(DIVIDE)) {
                return true;
            }
        }
        return false;
    }

    private int getIndexOfOperation(List<String> operations, String operation) throws ExpressionNotFoundException {
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i).equals(operation)) {
                return i;
            }
        }
        throw new ExpressionNotFoundException("Expression not found");
    }

    private double getResultFromPlusOrMinusOperation(List<String> operations, List<String> digits)
            throws ExpressionNotFoundException {
        if (operations.get(0).equals(PLUS)) {
            return Double.parseDouble(digits.get(0)) + Double.parseDouble(digits.get(1));
        } else if (operations.get(0).equals(MINUS)) {
            return Double.parseDouble(digits.get(0)) - Double.parseDouble(digits.get(1));
        }
        throw new ExpressionNotFoundException("Expression not found");
    }

    private String getOperation(List<String> operations) throws ExpressionNotFoundException {
        for (String operation : operations) {
            if (operation.equals(MULTIPLY) || operation.equals(DIVIDE)) {
                return operation;
            }
        }
        throw new ExpressionNotFoundException("Expression not found");
    }

    private Pair<Integer, Double> getIndexAndResult(List<String> operations, List<String> digits)
            throws DividingByZeroException, ExpressionNotFoundException {
        int index;
        if (isMultiplyOrDividingOperation(operations)) {
            if (getOperation(operations).equals(MULTIPLY)) {
                index = getIndexOfOperation(operations, MULTIPLY);
                return new Pair<>(index, Double.parseDouble(digits.get(index)) * Double.parseDouble(digits.get(index + 1)));
            } else if (getOperation(operations).equals(DIVIDE)) {
                index = getIndexOfOperation(operations, DIVIDE);
                dividingByZeroVerification(Double.parseDouble(digits.get(index + 1)));
                return new Pair<>(index, Double.parseDouble(digits.get(index)) / Double.parseDouble(digits.get(index + 1)));
            }
        } else {
            return new Pair<>(0, getResultFromPlusOrMinusOperation(operations, digits));
        }
        throw new ExpressionNotFoundException("Expression not found");
    }

    private boolean minusInStartOfInputValue(List<String> operations) {
        return operations.get(0).equals(MINUS);
    }

    private void dividingByZeroVerification(double value) throws DividingByZeroException {
        if (value == 0) {
            throw new DividingByZeroException("Dividing by zero");
        }
    }

    private void inputValueVerification(String inputLine) throws ExpressionNotFoundException {
        Pattern pattern = Pattern.compile("^[-]?\\d+\\.?(\\d+)?([-+/x]\\d+\\.?(\\d+)?$)+");
        Matcher matcher = pattern.matcher(inputLine);
        if (!matcher.find()) {
            throw new ExpressionNotFoundException("Input line was not correct format");
        }
    }
}
