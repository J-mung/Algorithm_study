package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class Simple369Game_1926 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String str = i + "";

            // String.contains() 좋네
            if (str.contains("3") || str.contains("6") || str.contains("9")) {

                // 369는 "-"로 바꿀 생각을 했으면서
                str = str.replaceAll("[369]", "-");

                // 그 외의 숫자를 ""로 바꿀 생각은 왜 안 했을까ㅎ..
                str = str.replaceAll("[0124578]", "");
            }
            System.out.print(str + " ");
        }
    }
}
