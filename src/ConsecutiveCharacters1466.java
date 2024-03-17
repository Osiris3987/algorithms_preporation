public class ConsecutiveCharacters1466 {

    public static void main(String[] args) {
        System.out.println(maxPower("a"));
    }

    public static int maxPower(String s) {
        int ans = 0;
        int len = 1;
        for(int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i-1)){
                len++;
            }
            else {
                ans = Math.max(ans, len);
                len = 1;
            }
        }
        return Math.max(ans, len);
    }

}
