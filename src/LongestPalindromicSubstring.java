public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
    private static String expandAroundCenter(String s, int left, int right){
        while(right != s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    public static String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length()/2+1; i++){
            String str1 = expandAroundCenter(s, i, i);
            String str2 = expandAroundCenter(s, i, i+1);
            if(ans.length() < str1.length()) ans = str1;
            if(ans.length() < str2.length()) ans = str2;
        }
        return ans;
    }
}
