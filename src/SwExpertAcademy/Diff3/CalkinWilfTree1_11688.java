package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    Calkin-Wilf tree는 모든 양의 유리수를 정확히 하나씩 포함하고 있는 트리다. 이 트리는 다음과 같이 정의된다

    ∙ 트리의 루트는 1/1 을 나타낸다.
    ∙ 트리의 각 노드는 왼쪽 자식과 오른쪽 자식을 가지는데 어떤 노드가 a/b 를 나타내고 있다면, 왼쪽 자식은 a/a+b 를 오른쪽 자식은 a+b/b 를 나타낸다.

    루트 노드에서부터, 자식을 따라 내려간 방향이 순서대로 주어질 때, 마지막에 위치한 노드가 어떤 유리수를 나타내는지 구하는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 길이 1이상 30이하인 문자열이 주어진다.

    이 문자열은 ‘L’또는 ‘R’로만 이루어져 있으며, i번째 문자가 ‘L’이면 i번째로 이동할 때 현재 노드에서 왼쪽으로,

    ‘R’이면 i번째로 이동할 때 현재 노드에서 오른쪽으로 내려갔음을 의미한다.

    15
    L
    R
    LL
    LR
    RL
    RR
    LLL
    LRL
    LRR
    RLR
    RRL
    LLRLLRLRLLRRRRLRLRLLRLLRLRLLRR
    LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
    LLLLLLLLLLRLLLLLLLLLLLLLLLLLLL
    RRRRRRRRRRRRRRRRRRRRRRRRRRLRRR

    [출력]
    각 테스트 케이스마다 주어진 문자열을 따라 이동을 끝냈을 때,

    위치한 노드가 나타내는 유리수가 기약분수로 a/b 이면 a와 b를 공백 하나로 구분하여 출력한다.

    #1 1 2
    #2 2 1
    #3 1 3
    #4 3 2
    #5 2 3
    #6 3 1
    #7 1 4
    #8 3 5
    #9 5 2
    #10 5 3
    #11 3 4
    #12 618347 259846
    #13 1 31
    #14 12 239
    #15 111 28
*/

public class CalkinWilfTree1_11688 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            char[] inputs = sc.next().toCharArray();

            // node : a / b
            // left child : a / (a + b)
            // right child : (a + b) / b
            // root node : 1 / 1
            int a = 1;
            int b = 1;
            for (int j = 0; j < inputs.length; j++) {
                if (inputs[j] == 'L') {
                    b = a + b;
                }
                if (inputs[j] == 'R')
                    a = a + b;
            }

            System.out.println("#" + (i + 1) + " " + a + " " + b);
        }
    }
}
