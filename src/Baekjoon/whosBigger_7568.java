package Baekjoon;

import java.util.*;

public class whosBigger_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pair[] pairs = new Pair[N];

        for(int i = 0; i < N; i++)
            pairs[i] = new Pair(sc.nextInt(), sc.nextInt());    // 몸무게, 키 입력

        for(int i = 0; i < N; i++) {
            int rank = 1;                                       // 등수는 1부터 시작

            for(int j = 0; j < N; j++) {
                if(i == j) continue;                            // 본인의 정보는 비교 안 함
                if(pairs[i].moreSmaller(pairs[j]))              // i가 j보다 덩치가 작으면 등수 하락
                    rank++;
            }
            System.out.println(rank + " ");
        }
    }
}

// 몸무게 및 키를 관리하는 class
class Pair {
    private int weight, height;

    public Pair(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    public boolean moreSmaller(final Pair o) {
        if(weight < o.weight && height < o.height)              // 덩치가 분명하게 작다면
            return true;
        return false;
    }
}