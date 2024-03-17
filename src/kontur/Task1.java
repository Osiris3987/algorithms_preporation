package kontur;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ones = scanner.nextInt();
        int twos = scanner.nextInt();
        int result = 0;

        while(ones != 0 && twos != 0){
            result += 2;
            result += 1;
            twos--;
            ones--;
        }

        if(twos > ones) {
            result += 2;
        }
        if(twos < ones) {
            result += 1;
        }

        System.out.println(result);
    }
}
