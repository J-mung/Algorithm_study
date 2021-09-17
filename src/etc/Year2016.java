/*
문제 설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지
리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

입출력 예
a	b	result
5	24	"TUE"
 */
package etc;

public class Year2016 {
    public static void main(String[] args) {
        int a = 5, b = 24;
        String answer="";
        int month = a - 1;
        int days = b - 1;

        // converted
        while(month > 0) {
            switch(month--) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    days += 31;
                    break;
                case 4: case 6: case 9: case 11:
                    days += 30;
                    break;
                default :
                    days += 29;
                    break;
            }
        }

        switch(days % 7) {
            case 0:
                answer="FRI";
                break;
            case 1:
                answer="SAT";
                break;
            case 2:
                answer="SUN";
                break;
            case 3:
                answer="MON";
                break;
            case 4:
                answer="TUE";
                break;
            case 5:
                answer="WED";
                break;
            case 6:
                answer="THU";
                break;
        }
        System.out.println("Day of the week : " + answer);
    }
}

