package SwExpertAcademy.Diff2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewInsomniaTreatment_1288_bit_operator {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int cur = 0;
            int validate = (1 << 10) -1;
            int multi = 0;
            while(validate > 0) {
                //새로운 숫자 만들기.
                cur = N * (multi++);
                //검증하기
                while(cur > 0) {
                    int temp = cur % 10;

                    // 비트를 하나씩 제거함으로써 정답을 도출
                    validate &= ~(1 << temp);
                    cur /= 10;
                }
            }
            System.out.println("#"+ test_case+ " "+ N * (multi-1));
        }
    }
}
