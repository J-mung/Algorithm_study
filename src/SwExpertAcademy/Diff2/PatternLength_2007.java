package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class PatternLength_2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            for (int j = 1; j < str.length(); j++) {

                // 앞의 단어와 뒤의 단어가 동일한 구간을 찾을 때까지
                // 범위를 1씩 늘려서 비교
                String prev = str.substring(0, j);
                String next = str.substring(j, j + j);
                if (prev.equals(next)) {
                    System.out.println("#" + (i + 1) + " " + prev.length());
                    break;
                }
            }
        }
    }
}
