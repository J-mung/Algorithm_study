package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class Calendar_2056_model_1 {
    public static int arr[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        String str;
        int tc;
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();

        for (int i = 1; i <= tc; i++) {
            str = sc.next();
            int year = Integer.parseInt(str.substring(0, 4));
            int month = Integer.parseInt(str.substring(4, 6));
            int day = Integer.parseInt(str.substring(6, 8));
            if (month < 13 && month > 0 && day <= arr[month])
                System.out.println("#" + i + " " + getYear(year) + "/" + getMonth(month) + "/" + getDay(day));
            else
                System.out.println("#" + i + " -1");
        }
    }

    public static String getDay(int day) {
        return String.format("%02d", day);
    }

    private static String getMonth(int month) {
        return String.format("%02d", month);
    }

    private static String getYear(int year) {
        return String.format("%04d", year);
    }
}
