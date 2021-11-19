/*
문제설명
네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때
일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

숫자	영단어
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine

제한사항
1 ≤ s의 길이 ≤ 50
s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.

입출력 예
s	result
"one4seveneight"	1478
"23four5six7"	234567
"2three45sixseven"	234567
"123"	123
 */
package Kakao;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NumberWord {
    public static void main(String[] args){
        String s = "2three45sixseven";
        // 영어단어를 숫자로 매핑
        Map<String, String>numWord = new HashMap<>();
        numWord.put("zero", "0");
        numWord.put("one", "1");
        numWord.put("two", "2");
        numWord.put("three", "3");
        numWord.put("four", "4");
        numWord.put("five", "5");
        numWord.put("six", "6");
        numWord.put("seven", "7");
        numWord.put("eight", "8");
        numWord.put("nine", "9");
        // 숫자인지 아닌지 확인하는 패턴
        String pattern = "^[0-9]*$";
        String answer = "";
        
        // 숫자면 한 글자씩, 영단어면 case별로 동작
        for(int idx= 0; idx < s.length();) {

            if(Pattern.matches(pattern, s.substring(idx, idx+1))) {
                answer += s.charAt(idx);
                idx++;
            }
            else {
                switch(s.charAt(idx)){
                    case'z':
                        answer += numWord.get(s.substring(idx,idx+4));
                        idx+=4;
                        break;
                    case'o':
                        answer += numWord.get(s.substring(idx,idx+3));
                        idx+=3;
                        break;
                    case't':
                        if(s.substring(idx, idx+3).equals("two")) {
                            answer += numWord.get(s.substring(idx,idx+3));
                            idx += 3;
                        } else {
                            answer += numWord.get(s.substring(idx,idx+5));
                            idx += 5;
                        }
                        break;
                    case'f':
                        answer += numWord.get(s.substring(idx, idx + 4));
                        idx += 4;
                        break;
                    case's':
                        if(s.substring(idx,idx+3).equals("six")) {
                            answer += numWord.get(s.substring(idx, idx + 3));
                            idx += 3;
                        } else {
                            answer += numWord.get(s.substring(idx, idx + 5));
                            idx+=5;
                        }
                        break;
                    case'e':
                        answer += numWord.get(s.substring(idx, idx + 5));
                        idx += 5;
                        break;
                    case'n':
                        answer += numWord.get(s.substring(idx,idx+4));
                        idx+=4;
                        break;
                }
            }
        }
        System.out.println("answer : " + answer);
        int num = Integer.parseInt(answer);
    }
}
