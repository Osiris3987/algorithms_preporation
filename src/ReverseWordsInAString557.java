public class ReverseWordsInAString557 {
    public static void main(String[] args) {
        System.out.println(reverseWords("God Ding"));
    }
    public static String reverseWords(String s){
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = s.split(" ");

        for(String str: strs){
            for(int i = str.length() - 1; i >= 0; i--){
                stringBuilder.append(str.charAt(i));
            }
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}
