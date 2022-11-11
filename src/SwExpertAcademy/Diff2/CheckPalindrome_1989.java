package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class CheckPalindrome_1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            String str = sc.next();

            int result = 1;
            int length = str.length();
            for (int j = 0; j < length / 2; j++) {
                if (str.charAt(j) != str.charAt((length - 1) - j)) {
                    result = 0;
                    break;
                }
            }

            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
