package Stepdefs;

public class PasswordComparator {

    //    Old password should match with system
//    New password should be a valid password
// password is not similar to old password < 80% match.

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword)) {
            System.out.println("new and old password can't be same");
            return false;
        } else
            return true;
    }

    public boolean similarityCheck(String oldPassword, String newPassword, int percentMatch) {
        if (oldPassword.length() == 0) return false;
        int numberOfSimilarities = 0;
        for (int i = 0; i < oldPassword.length(); ++i) {
            if (oldPassword.charAt(i) == newPassword.charAt(i)) {
                ++numberOfSimilarities;
            }
        }
        System.out.println((double) numberOfSimilarities / oldPassword.length());
        if ((double) numberOfSimilarities / oldPassword.length() >= percentMatch)
            return false;
        else
            return true;
    }

}
