package week1.dp;

public class exercise2 {
    public class LongestCommonSubsequence {

        // Function to find LCS
        private static String findLCS(String s1, String s2) {
            int m = s1.length();
            int k = s2.length();
            int[][] dp = new int[m + 1][k + 1];

            // Fill dp array
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= k; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // Reconstruct LCS from dp array
            int i = m, j = k;
            StringBuilder lcs = new StringBuilder();
            while (i > 0 && j > 0) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs.insert(0, s1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            return lcs.toString();
        }

        public static void main(String[] args) {
            String s1 = "AGGTAB";
            String s2 = "GXTXAYB";

            String lcs = findLCS(s1, s2);
            System.out.println("Longest Common Subsequence = " + lcs);
        }
    }

}
