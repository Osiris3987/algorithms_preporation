package kontur;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = "";
        s = scanner.next();
        int rMax = maxColor(s, k, 'G', 'B');
        int bMax = maxColor(s, k, 'G', 'R');
        int gMax = maxColor(s, k, 'R', 'B');
        System.out.println(Math.max(Math.max(rMax, bMax), gMax));
    }

    public static int maxColor(String s, int flips, char color1, char color2) {
        int len = 0;
        int start = 0;
        int wrongColorCounter = 0;
        for(int end = 0; end< s.length(); end++){
            if(s.charAt(end)==color1 || s.charAt(end) == color2){
                wrongColorCounter++;
            }
            while(start<s.length() && wrongColorCounter>flips){
                if(s.charAt(start)==color1 || s.charAt(start) == color2){
                    wrongColorCounter--;
                }
                start++;
            }
            len = Math.max(len, end - start + 1);
        }
        return len;
    }
}
