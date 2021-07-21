/*
문제 설명
두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서,
약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ left ≤ right ≤ 1,000

입출력 예
left	right	result
13	17	43
24	27	52
 */
package etc;

public class MeasureNumPlus {
    public static void main(String[] args) {
        int left = 24, right = 27;
        int answer = 0;

        for(int i = left; i <= right; i++) {
            /*if(countMeasure(i) % 2 == 0) {
                answer += i;
            }
            else {
                answer -= i;
            }*/
            answer += i * ((countMeasure(i) % 2 == 0) ? 1 : -1);
        }

        System.out.println(answer);
    }

    public static int countMeasure(int num) {
        int count = 0;
        int sqrn = (int)Math.sqrt(num);
        for(int div = 1; div <= sqrn; div++) {
            if(num % div == 0) {
                count++;
            }
        }

        return sqrn * sqrn != num ? count*2 : count*2-1;
    }
}
