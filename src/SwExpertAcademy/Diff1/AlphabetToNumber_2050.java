package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class AlphabetToNumber_2050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            char alpa = str.charAt(i);
            System.out.print(((int)alpa - 'A' + 1) + " ");
        }
    }
}
