package Stepdefs;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.JaccardSimilarity;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.apache.commons.text.similarity.SimilarityScore;

public class PasswordComparator {
    //    Old password should match with system
//    New password should be a valid password
// password is not similar to old password < 80% match.

    public boolean changePassword(String oldPassword, String newPassword, int percentMatch) {
        boolean flag = false;
        if (oldPassword.equals(newPassword)) {
            return false;
        } else if (oldPassword.length() == newPassword.length()) {
            flag = similarityCheckSameLength(oldPassword, newPassword, percentMatch);
        } else {
            flag=true;
        }
        return flag;
    }

    public boolean similarityCheckSameLength(String oldPassword, String newPassword, int percentMatch) {
        if (oldPassword.length() == 0) return false;
        int numberOfSimilarities = 0;
        for (int i = 0; i < oldPassword.length(); ++i) {
            if (oldPassword.charAt(i) == newPassword.charAt(i)) {
                ++numberOfSimilarities;
            }
        }
        System.out.println((double) numberOfSimilarities / oldPassword.length());
        if ((double) numberOfSimilarities / oldPassword.length()*100 >= percentMatch) {
            System.out.println("More than 80% similarity found between old and new password");
            return false;
        }else
            return true;
    }

    /*public boolean similarityCheckUnequalLength(String oldPassword, String newPassword, int percentMatch){
        int numberOfSimilarities = 0;
        int lmin = Math.min(oldPassword.length(), newPassword.length());

        for (int i = 0; i < lmin; i++) {
            if (oldPassword.charAt(i) == newPassword.charAt(i)) {
                ++numberOfSimilarities;
            }
        }
        System.out.println((double) numberOfSimilarities / oldPassword.length());
        if ((double) numberOfSimilarities / oldPassword.length() >= percentMatch)
            return false;
        else {
            System.out.println("Password Accepted");
            return true;
        }
    }*/

    public static void main(String[] args) {
        compareStrings("aditi","aditimittal");
    }
    public static void compareStrings(String stringA, String stringB) {
        int changesreq=StringUtils.getLevenshteinDistance(stringA, stringB);
        System.out.println(changesreq );
        System.out.println(new JaccardSimilarity().apply("aditi","aditimittal"));
        System.out.println(new JaroWinklerSimilarity().apply("ExistingPassword@123","ExistingPassworr!456"));
    }

    /*public static int distance(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++)
        {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++)
            {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        System.out.println(costs[b.length()]);
        return costs[b.length()];
    }
*/
}
