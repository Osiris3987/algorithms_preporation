package kontur;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder leftAns = new StringBuilder();
        StringBuilder rightAns = new StringBuilder();
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        int left = 0;
        int right = arr.length - 1;
        int leftSum = arr[left];
        int rightSum = arr[right];
        leftAns.append(arr[left]);
        rightAns.append(arr[right]);

        while(left != right-1){
            if(leftSum < rightSum){
                left++;
                leftSum += arr[left];
                leftAns.append("+").append(arr[left]);
            } else {
                right--;
                rightSum += arr[right];
                rightAns.append("+").append(arr[right]);
            }
        }
        if(rightSum == leftSum) {
            leftAns.append("=");
            for(int i = right; i < arr.length; i++){
                leftAns.append(arr[i]).append("+");
            }
            leftAns.deleteCharAt(leftAns.length()-1);
            System.out.println(leftAns);
        } else {
            System.out.println(-1);
        }
    }
}
