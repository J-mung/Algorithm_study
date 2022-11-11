package SwExpertAcademy.Diff2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Grading_1983 {
    private static final String[] GRADE = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            tokens = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tokens.nextToken());
            int K = Integer.parseInt(tokens.nextToken());

            // 총점 테이블
            float[] gradeTable = new float[N];

            // 간접 정렬에 쓰일 인덱스 배열
            int[] sorted = new int[N];

            for (int j = 0; j < N; j++) {
                sorted[j] = j;
                gradeTable[j] = getGrade();
            }

            for (int j = 1; j < N; j++) {

                // 정렬해야 할 총점
                float val = gradeTable[sorted[j]];

                // 총점의 인덱스
                int idx = sorted[j];

                // 삽입 정렬 사용용
                int k;
                for (k = j - 1; k >= 0 && gradeTable[sorted[k]] < val; k--) {
                    sorted[k + 1] = sorted[k];
                }
                sorted[k + 1] = idx;
            }

            // K 학생의 총점이 몇 번 째인지 sorted 배열에서 확인 후 GRADE 출력
            for (int j = 0; j < N; j++) {
                if (sorted[j] == K - 1) {
                    int idx = N > 10 ? j / (N / 10) : j;
                    System.out.println("#" + (i + 1) + " " + GRADE[idx]);
                    break;
                }
            }
        }
    }

    // 총점 계산
    private static float getGrade() throws IOException {
        float grade = 0;

        tokens = new StringTokenizer(br.readLine());
        grade += Integer.parseInt(tokens.nextToken()) * (float) 0.35;
        grade += Integer.parseInt(tokens.nextToken()) * (float) 0.45;
        grade += Integer.parseInt(tokens.nextToken()) * (float) 0.20;

        return grade;
    }
}
