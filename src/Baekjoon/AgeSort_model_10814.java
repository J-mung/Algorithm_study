package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AgeSort_model_10814 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력되는 나이의 범위 : 1 ~ 200
        StringBuffer[] sb = new StringBuffer[201];

        // 객체배열의 인덱스에 각 StringBuilder 객체를 생성해준다.
        for(int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            // 카운팅 정렬 : 나이를 index 로 하여 해당 배열에 나이와 이름을 append() 한다.
            sb[age].append(age + " " + name + "\n");
        }

        StringBuffer result = new StringBuffer();
        for(StringBuffer str : sb) {
            result.append(str);
        }

        System.out.println(result);
    }
}
