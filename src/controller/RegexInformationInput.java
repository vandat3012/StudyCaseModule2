package controller;

import java.util.Scanner;

public class RegexInformationInput {
    private static final String REGEX_ID = "^([0-9]|[1-9][0-9])?$";
    private static final String REGEX_AGE = "^[2-9][0-9]?$";
    private static final String REGEX_NAME = "^[a-zA-Z]+$";
    private static final String REGEX_GENDER = "^(M|W)$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String REGEX_NATION = "^[A-Z]+$";
    private static final String REGEX_NUM = "^[0-9]+$";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getRegexId() {
        String input = scanner.nextLine();
        while (!String.valueOf(input).matches(REGEX_ID)) {
            System.out.println("Sai định dạng, Vui lòng nhập lại lần nữa ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getRegexName() {
        String input = scanner.nextLine();
        while (!String.valueOf(input).matches(REGEX_NAME)) {
            System.out.println("Sai định dạng, Vui lòng nhập lại lần nữa ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getRegexAge() {
        String input = scanner.nextLine();
        while (!String.valueOf(input).matches(REGEX_AGE)) {
            System.out.println("Sai định dạng, Vui lòng nhập lại lần nữa ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getRegexGender() {
        String input = scanner.nextLine();
        while (!String.valueOf(input).matches(REGEX_GENDER)) {
            System.out.println("Sai định dạng, Vui lòng nhập lại lần nữa ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getRegexEmail() {
        String input = scanner.nextLine();
        while (!String.valueOf(input).matches(REGEX_EMAIL)) {
            System.out.println("Sai định dạng, Vui lòng nhập lại lần nữa ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getRegexNation() {
        String input = scanner.nextLine();
        while (!String.valueOf(input).matches(REGEX_NATION)) {
            System.out.println("Sai định dạng, Vui lòng nhập lại lần nữa ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getRegexNum() {
        String input = scanner.nextLine();
        while (!String.valueOf(input).matches(REGEX_NUM)) {
            System.out.println("Sai định dạng, Vui lòng nhập lại lần nữa ");
            input = scanner.nextLine();
        }
        return input;

    }
}
