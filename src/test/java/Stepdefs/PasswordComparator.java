package Stepdefs;

public class PasswordComparator {

    //    Old password should match with system
//    New password should be a valid password
// password is not similar to old password < 80% match.

    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword))
            System.out.println("new and old password can't be same");
        else {

        }

    }

    public double similarityCheck(String oldPassword, String newPassword) {
        if(oldPassword.length() == 0) return 1;
        int numberOfSimilarities = 0;
        for(int i = 0; i < oldPassword.length(); ++i) {
            if(oldPassword.charAt(i) == newPassword.charAt(i)) {
                ++numberOfSimilarities;
            }
        }
        System.out.println((double) numberOfSimilarities / oldPassword.length());
        return (double) numberOfSimilarities / oldPassword.length();
    }

    public void systemMatch(String password){

    }

}
