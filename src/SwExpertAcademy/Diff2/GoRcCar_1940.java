package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class GoRcCar_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            int distance = 0;
            int command = 0;
            int speed = 0;
            int down = 0;

            for (int j = 0; j < n; j++) {
                command = sc.nextInt();

                if (command == 1)
                    speed += sc.nextInt();
                else if (command == 2) {
                    down = sc.nextInt();
                    speed = speed > down ? speed - down : 0;
                }
                distance += speed;
            }
            System.out.format("#%d %d\n", (i + 1), distance);
        }
    }
}
