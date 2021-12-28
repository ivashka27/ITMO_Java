package expression.parser;

import expression.*;

import java.nio.charset.Charset;
import java.util.*;



public class ExpressionParser implements Parser {

    private ArrayList<String> parsed;
    private static Set<Character> operations = Set.of('+', '-', '/', '*', ')', '(');
    private int idx = 0;

    public ArrayList<String> parseAll(String str) {
        boolean expectOperation = false;
        ArrayList<String> elems = new ArrayList<>();
        int idx = 0;
        while (idx < str.length()) {
            StringBuilder res = new StringBuilder();
            while (idx < str.length() && (Character.isWhitespace(str.charAt(idx)))) {
                idx++;
            }
            if (idx >= str.length()) {
                break;
            }
            if (str.charAt(idx) == '-' && Character.isDigit(str.charAt(idx + 1)) && !expectOperation) {
                res.append('-');
                idx++;
                while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
                    res.append(str.charAt(idx));
                    idx++;
                }
                expectOperation = true;
            } else if (operations.contains(str.charAt(idx))) {
                res.append(str.charAt(idx));
                idx++;
                expectOperation = false;
            } else if (Character.isDigit(str.charAt(idx)) || Character.isLetter(str.charAt(idx))) {
                while (idx < str.length() && (Character.isDigit(str.charAt(idx)) || Character.isLetter(str.charAt(idx)))) {
                    res.append(str.charAt(idx));
                    idx++;
                }
                expectOperation = !res.toString().equals("l0") && !res.toString().equals("t0") &&
                        !res.toString().equals("min") && !res.toString().equals("max");
            }
            if (res.toString().length() == 0) {
                break;
            }
            elems.add(res.toString());
        }
        return elems;

    }

    @Override
    public TripleExpression parse(String parseAddSub) {
        idx = 0;
        parsed = parseAll(parseAddSub);
        return parseMinMax();
    }

    private CommonExpression parseMinMax() {
        CommonExpression finalResult = parseAddSub();
        while (idx < parsed.size()) {
            String op = parsed.get(idx);
            if (op.equals("max") || op.equals("min")) {
                idx++;
            } else {
                break;
            }
            CommonExpression curr = parseAddSub();
            if (op.equals("max")) {
                finalResult = new Max(finalResult, curr);
            } else {
                finalResult = new Min(finalResult, curr);
            }
        }
        return finalResult;
    }

    private CommonExpression parseAddSub() {
        CommonExpression finalResult = parseMulDiv();
        while (idx < parsed.size()) {
            String op = parsed.get(idx);
            if (op.equals("+") || op.equals("-")) {
                idx++;
            } else {
                break;
            }
            CommonExpression curr = parseMulDiv();
            if (op.equals("+")) {
                finalResult = new Add(finalResult, curr);
            } else {
                finalResult = new Subtract(finalResult, curr);
            }
        }
        return finalResult;
    }

    private CommonExpression parseMulDiv() {
        CommonExpression finalResult = parseUnary();
        while (idx < parsed.size()) {
            String op = parsed.get(idx);
            if (op.equals("*")
                    || op.equals("/")) {
                idx++;
            } else {
                break;
            }
            CommonExpression curr = parseUnary();
            if (op.equals("*")) {
                finalResult = new Multiply(finalResult, curr);
            } else {
                finalResult = new Divide(finalResult, curr);

            }
        }
        return finalResult;
    }

    private CommonExpression parseUnary() {
        String curr = parsed.get(idx);
        CommonExpression finalResult, unaryResult;
        if (curr.equals("(")) {
            idx++;
            finalResult = parseMinMax();
            String brackets = "";
            if (idx < parsed.size()) {
                brackets = parsed.get(idx);
            }
            if (brackets.equals(")")) {
                idx++;
                return finalResult;
            }
        }
        idx++;

        if ("-".equals(curr)) {
            unaryResult = parseUnary();
            return new UnaryMinus(unaryResult);
        } else if ("t0".equals(curr)) {
            unaryResult = parseUnary();
            return new T0(unaryResult);
        } else if ("l0".equals(curr)) {
            unaryResult = parseUnary();
            return new L0(unaryResult);
        }

        if (Character.isLetter(curr.charAt(0))) {
            return new Variable(curr);
        } else {
            return new Const(Integer.parseInt(curr));
        }
    }
}