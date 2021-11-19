/*
문제 설명
데이터 처리 전문가가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다.
최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이
연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
간단한 예로 "aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데,
이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, "abcabcdede"와 같은 문자열은
전혀 압축되지 않습니다. "어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여
더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.

예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면
"2ab2cd2ab2cd"로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며,
이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, "abcabcdede"와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 "abcabc2de"가 되지만, 3개 단위로 자른다면
"2abcdede"가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중
가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

제한사항
s의 길이는 1 이상 1,000 이하입니다.
s는 알파벳 소문자로만 이루어져 있습니다.

입출력 예
s	result
"aabbaccc"	7
"ababcdcdababcdcd"	9
"abcabcdede"	8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd"	17
 */
package Kakao;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aabbaccc";
        int answer = 0;
        int num = 1;
        String[] bowl = new String[s.length()/2];   // 압축 가능한 조합의 문자열들
        String standard = "";                       // 기준 유닛
        String comparison = "";                     // 비교 유닛
        String temp = "";                           // bowl에 넣기 전 문자열

        for(int unit = 1; unit <= s.length() / 2; unit++) {
            standard = s.substring(0, unit);
            for(int i = unit; i < s.length(); i += unit) {
                // OutOfIndex 대비    *최적화 필요
                if(i + unit > s.length()) {
                    // Index 범위를 벗어남으로써 temp에 저장하지 못하는 잔여 문자 저장
                    standard += s.substring(i, s.length());
                    // 반복문 강제 탈출
                    continue;
                }
                // 비교 유닛 구하기
                comparison = s.substring(i, i + unit);
                // 기준 유닛과 비교 유닛 비교
                if(standard.equals(comparison)) {
                    // 동일하면 유닛 수 카운트
                    num++;
                } else {
                    // 그렇지 않으면 temp에 현재까지 구한 유닛 저장
                    if(num == 1)
                        temp += standard;
                    else
                        temp += num + standard;
                    num = 1;
                    // 기준 유닛 변경
                    standard = comparison;
                }
            }
            // 반복문 강제 탈출로 발생하는 잔여 문자열 합치기   *최적화 필요
            if(num > 1)
                temp += num + standard;
            else
                temp += standard;
            num = 1;
            // bowl에 저장
            bowl[unit - 1] = temp;
            temp = "";
        }

        // bowl에서 압축률이 가장 높은 문자열 길이 탐색
        if(s.length() == 1)
            answer = 1;
        else {
            answer = Integer.MAX_VALUE;
            for (int idx = 0; idx < bowl.length; idx++) {
                System.out.println(bowl[idx].length());
                if (answer > bowl[idx].length())
                    answer = bowl[idx].length();
            }
        }
        System.out.println("answer : " + answer);
    }
}
