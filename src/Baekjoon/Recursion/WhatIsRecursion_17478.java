package Baekjoon.Recursion;

import java.util.Scanner;

public class WhatIsRecursion_17478 {
    private static StringBuilder result;
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        result = new StringBuilder();

        result.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        solution(N, 0);

        System.out.println(result);
    }

    private static void solution(int N, int depth) {
        inputString("\"재귀함수가 뭔가요?\"", depth);
        if(N < 1) {
            inputString("\"재귀함수는 자기 자신을 호출하는 함수라네\"", depth);
            inputString("라고 답변하였지.", depth);
            return;
        } else {
            inputString("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", depth);
            inputString("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", depth);
            inputString("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"", depth);
        }
        solution(N - 1, depth + 1);
        inputString("라고 답변하였지.", depth);
        return;
    }

    private static void inputString(String str, int depth) {
        inputDash(depth);
        result.append(str).append("\n");
    }
    private static void inputDash(int depth) {
        String dash = "_";
        result.append(dash.repeat(depth *  4));
    }
}
