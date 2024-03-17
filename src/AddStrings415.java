import java.util.Arrays;

public class AddStrings415 {

    public static void main(String[] args) {
        System.out.println(addStrings("0", "0"));
    }

    public static String addStrings(String s1, String s2){

        int len = Math.max(s1.length(), s2.length())+1;
        int minLen = Math.min(s1.length(), s2.length());

        char[] arr1 = new char[len];
        char[] arr2 = new char[len];
        Arrays.fill(arr1, '0');
        Arrays.fill(arr2, '0');
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < s1.length(); i++) {
            arr1[i] = s1.charAt(s1.length() - i - 1);
        }

        for(int i = 0; i < s2.length(); i++) {
            arr2[i] = s2.charAt(s2.length() - i - 1);
        }

        int curr = 0;

        for(int i = 0; i < len; i++) {
            int res = (arr1[i] - 48) + (arr2[i] - 48) + curr;
            if(res < 10) {
                stringBuilder.insert(0, res);
                curr = 0;
            } else {
                stringBuilder.insert(0, res % 10);
                curr = res / 10;
            }
        }

        if(stringBuilder.charAt(0) == '0'){
            return stringBuilder.substring(1, stringBuilder.length());
        }

        return stringBuilder.toString();
    }
}
