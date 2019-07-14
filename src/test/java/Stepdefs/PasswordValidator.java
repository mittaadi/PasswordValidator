package Stepdefs;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        new PasswordValidator();
    }

    public void checkPasswordIsValid(String password) {

    }

//    At least 18 alphanumeric characters and list of special chars !@#$&*
//    At least 1 Upper case, 1 lower case ,least 1 numeric, 1 special character
//    No duplicate repeat characters more than 4
//    No more than 4 special characters
//    50 % of password should not be a number

    public void duplicateRepeatCharCheck(String password, int dupCount) {
        Map<Character, Integer> countChar = new HashMap<>();
        Map<Character, Boolean> repeatedChar = new HashMap<>();
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (countChar.containsKey(ch)) {
                countChar.put(ch, countChar.get(ch) + 1);
            } else
                countChar.put(ch, 1);
        }
        System.out.println(countChar);
        for (Character ch : countChar.keySet()) {
            if (countChar.get(ch) > dupCount) {//4
                repeatedChar.put(ch, false);
                System.out.println("Character: " + ch + "actual occurence: " + countChar.get(ch) + " has been used more than " + dupCount + " times");
            }
        }
    }

    public boolean numCheck(String password, int numPercentAccepted) {
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) numCount++;
        }
        System.out.println("Length of the password is: " + password.length());
        System.out.println("Count of numbers in password: " + numCount);
        if (numCount >= password.length() / numPercentAccepted) { //5
            System.out.println("50 % of password should not be a number");
            return false;
        } else
            return true;
    }

    public boolean lengthCheck(String password, int passwordLength) {
        if (password.length() < passwordLength) {
            System.out.println("password not accepted length less than 18");
            return false;
        } else
            return true;
    }

    public boolean specialCharCheck(String password, String specialChar) {
        Pattern regex = Pattern.compile("specialChar");//[@#$&*!]
        if (regex.matcher(password).find()) {
//            System.out.println("password accepted");
            return true;
        } else {
            System.out.println("special character other than " + specialChar + " not accepted");
            return false;
        }
    }

    public boolean minCharCheck(String password) {
        int charCount = 0;
        int numCount = 0;
        int letterCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) numCount++;
            else if (isLetterUpper(ch)) charCount++;
            else if (Character.isLetter(ch)) letterCount++;
        }
        String SPECIAL_CHAR_REGEX = "[@#$&*!]";
        int specials = password.split(SPECIAL_CHAR_REGEX).length - 1;


        if (charCount > 0 && numCount > 0 && letterCount > 0 && specials > 0 && specials <= 4) {
            System.out.println("Number of uppercase letters: " + charCount);
            System.out.println("Number of numeric letters: " + numCount);
            System.out.println("Special charcter count: " + specials);
            return true;
        } else return false;
    }

    public boolean isLetterUpper(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    //single method for min checks
   /* public void minChecks(String password) {
        String passwordPattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=\\S+$).{18,}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        if (pattern.matcher(password).matches())
            System.out.println("password accepted");
        else
            System.out.println("pass not accepted");
    }
*/
    //
    /*public void createPassword(int passwordLength) {
        StringBuilder password = new StringBuilder(passwordLength);
        String letters = ("abcdefghijklmnopqrstuvwxyz");
        String digits = ("1234567890");
        String symbols = ("@#$%!");

        Random num = new Random();

        for (int i = 0; i < passwordLength - 2; i++) {
            if (i % 2 == 0) {
                password.append(letters.charAt(num.nextInt(letters.length())));
            } else {
                password.append(letters.toUpperCase().charAt(num.nextInt(letters.length())));
            }
        }

        //add digit and symbol to match criteria
        password.append(digits.charAt(num.nextInt(digits.length())));
        password.append(symbols.charAt(num.nextInt(symbols.length())));
//        System.out.println(StringUtils.countMatches("a.b.c.d", "."));
        System.out.println("Created password is " + password);
    }*/
}
