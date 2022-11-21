package SwExpertAcademy.Diff3;

import java.util.Scanner;
import java.util.Stack;

/*
    [설명]
     세계 최고의 명문 대학교 삼성대학교에는 수많은 교환학생들이 존재한다.

     삼성대학교는 연중무휴로 운영되지만, 교환학생들을 위한 수업은 특정 요일에만 진행된다.

     이 정보는 7개의 정수 a1, a2, …, a7으로 표현되는데 (ai = 0 or ai = 1):

      · 일요일에 교환학생을 위한 수업이 열리면 a1 = 1, 아니면 0
      · 월요일에 교환학생을 위한 수업이 열리면 a2 = 1, 아니면 0
      · …
      · 토요일에 교환학생을 위한 수업이 열리면 a7 = 1, 아니면 0

      수업이 어떠한 요일에도 열리지 않는 경우는 없다고 가정해도 된다.

      당신은 삼성대학교에서 교환학생으로 n일 동안 수업을 들으려고 한다.

      목표를 이루기 위해 삼성대학교에 지내야 하는 최소 일수를 출력하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.

    각 테스트 케이스는 다음과 같이 구성되었다.

      · 첫 번째 줄에 정수 n이 주어진다. (1≤ n ≤105)
      · 이후 7개의 정수 a1, a2, …, a7이 주어진다. (0 ≤ ai ≤ 1)

    3
    2
    0 1 0 0 0 0 0
    100000
    1 0 0 0 1 0 1
    1
    1 0 0 0 0 0 0

    [출력]
    각 테스트 케이스마다 문제의 정답을 출력하라.

    #1 8
    #2 233332
    #3 1

*/

public class ExchangeStudent_13038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int goal = sc.nextInt();
            int[] days = new int[7];
            Stack<Integer> stack = new Stack<Integer>();

            for (int j = 0; j < 7; j++) {
                days[j] = sc.nextInt();
                if (days[j] == 1)
                    stack.add(j);
            }

            int min = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int tmp = 0;
                int idx = stack.pop();
                int loopGoal = goal;

                while (loopGoal > 0) {
                    if (days[idx] == 1)
                        loopGoal--;
                    tmp++;
                    idx = (idx + 1) % 7;
                }

                if (min > tmp)
                    min = tmp;
            }

            System.out.println("#" + (i + 1) + " " + min);
        }

    }
}
