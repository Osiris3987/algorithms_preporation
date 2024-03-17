package yandex_contest_demo_2024;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year1 = scanner.nextInt();
        int month1 = scanner.nextInt();
        int day1 = scanner.nextInt();
        int hour1 = scanner.nextInt();
        int min1 = scanner.nextInt();
        int sec1 = scanner.nextInt();

        int year2 = scanner.nextInt();
        int month2 = scanner.nextInt();
        int day2 = scanner.nextInt();
        int hour2 = scanner.nextInt();
        int min2 = scanner.nextInt();
        int sec2 = scanner.nextInt();

        long totalSeconds1 = calculateTotalSeconds(year1, month1, day1, hour1, min1, sec1);
        long totalSeconds2 = calculateTotalSeconds(year2, month2, day2, hour2, min2, sec2);

        long totalDays = (totalSeconds2 - totalSeconds1) / (24 * 60 * 60);
        long remainingSeconds = (totalSeconds2 - totalSeconds1) % (24 * 60 * 60);

        System.out.println(totalDays + " " + remainingSeconds);
    }

    public static long calculateTotalSeconds(int year, int month, int day, int hour, int min, int sec) {
        long totalDays = calculateTotalDays(year, month, day);
        long totalHours = totalDays * 24 + hour;
        long totalMinutes = totalHours * 60 + min;
        long totalSeconds = totalMinutes * 60 + sec;

        return totalSeconds;
    }

    public static long calculateTotalDays(int year, int month, int day) {
        long totalDays = day - 1;

        for (int i = 1; i < month; i++) {
            totalDays += getDaysInMonth(year, i);
        }

        for (int i = 1; i < year; i++) {
            totalDays += 365;
        }

        return totalDays;
    }

    public static int getDaysInMonth(int year, int month) {
        int daysInMonth;

        switch (month) {
            case 2:
                daysInMonth = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            default:
                daysInMonth = 31;
        }

        return daysInMonth;
    }
}
