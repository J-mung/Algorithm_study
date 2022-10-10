package Programmers.Sorting;

/*
    문제 설명
    0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
    예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
    0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록
    solution 함수를 작성해주세요.

    제한 사항
    numbers의 길이는 1 이상 100,000 이하입니다.
    numbers의 원소는 0 이상 1,000 이하입니다.
    정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

    입출력 예
    numbers	            return
    [6, 10, 2]	        "6210"
    [3, 30, 34, 5, 9]	"9534330"
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MostBiggerNumber {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokens.nextToken());
        }

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String[] result = new String[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 정수 값으로 변환해 비교함으로써 요구조건이 제시하는 크기가 더 큰 정수를 찾을 수 있음
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(o1 + " " + o2);
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        /*
         numbers의 elements가 모두 0일 때는 결과 값으로 "0"을 반환해줘야 함
         반대의 경우는 result의 자료형대로 보내면 되지만, 그러기 위해선 String or String[]로 선택지가 나뉘게 됨
         따라서 반환형을 String으로 통일하고 String.join()을 이용해 String[] -> String으로 형변환을 꾀함
        */
        return result[0].equals("0") ? result[0] : String.join("", result);
    }
}


