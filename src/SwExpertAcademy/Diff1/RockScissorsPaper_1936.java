package SwExpertAcademy.Diff1;

import java.util.Scanner;

/*
    가위 1
    바위 2
    보 3

    1 << 2 << 3 << 1

    3 1 / 1 2 / 2 3 B
    3 2 / 1 3 / 2 1 A

    2 1 A
    2 3 B
*/
public class RockScissorsPaper_1936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if ((b - a == 1) || (b - a == -2))
            System.out.println("B");
        else
            System.out.println("A");
    }
}
