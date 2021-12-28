package expression;

import expression.parser.ExpressionParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        System.out.println(new ExpressionParser().parse(s).toMiniString());
        //x*y+(z-1   )/10
    }
}
