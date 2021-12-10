package service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static Pattern pattern;
    private static Matcher matcher;
    public static final String ACCOUNT = "^[A-Za-z0-9]{6,}$";
    public static final String PASS = "^[A-z0-9A-z]{6,}$";
    public static final String NUMBER = "^[0-9]+$";
    public static final String PHONE = "^[0-9]{8}+$";
    public static final String DOUBLE = "^(\\d+\\.\\d+)|\\d+";
    public static final String NAME ="^\\pL+[\\pL\\pZ\\pP]{0,}$";
    public static final String EMAIL="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String STATUS="^AVAILABLE|READY|CLEANING$";
    public static final String ROOMTYPE="^VIP||DELUX||PREMIUM$";
    static Scanner sc = new Scanner(System.in);

    public static boolean validateAll(String value,String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);
        return matcher.matches();
    }
    public static String validate(String guide,String guideError,String regex) {
        while (true){
            System.out.println(guide);;
            String value = sc.nextLine();
            if(validateAll(value,regex)){
                return value;
            }else{
                System.err.println(guideError);
            }
        }
    }

    public static String validateNotNull(String guide,String guideError) {
        while (true){
            System.out.println(guide);;
            String value = sc.nextLine();
            if(!value.trim().equals("")){
                return value;
            }else{
                System.err.println(guideError);
            }
        }
    }
    public static String validateNotNull(String guideError) {
        while (true){
            String value = sc.nextLine();
            if(!value.trim().equals("")){
                return value;
            }else{
                System.err.println(guideError);
            }
        }
    }
}
