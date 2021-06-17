package Kakao;

import java.util.Locale;

public class RecomId_model {
    public static void main(String[] args) {
        String[] new_id = {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
        String answer = "";

        for(String id : new_id) {
            // 1단계. 대문자들을 소문자들로 치환
            String temp = id.toLowerCase();

            // [^abc] : a, b, c를 제외한 문자 1개
            // 2단계. 지정된 문자를 제외한 나머지 문자는 제거
            temp = temp.replaceAll("[^-_.a-z0-9]", "");
            System.out.println(temp);

            // [.]{2,} : 마침표(.)가 2개 이상 나타남
            // 3단계. 마침표(.)가 2자 이상 작성된 경우 마침표(.) 1자로 바꿈
            temp = temp.replaceAll("[.]{2,}", "");

            // ^[.]|[.]$ : ^ 다음 regex로 line을 시작하는지 또는 & 앞의 regex가 line의 마지막으로 끝나는지
            // 4단계. 문자열의 양끝이 마침표(.)이면 제거
            temp = temp.replaceAll("^[.]|[.]$", "");
            System.out.println(temp.length());

            // 5단계. 문자열이 빈 문자열이면 a를 채워줌
            if(temp.equals("")){
                temp += 'a';
            }
            // 6단계. 문자열이 16자 이상이면 첫 문자부터 15자까지 남김
            if(temp.length() >= 16) {
                temp = temp.substring(0,15);
                temp = temp.replaceAll("^[.]|[.]$", "");
            }
            // 7단계. 문자열의 길이가 2 이하면 3자 이상이 될때까지 문자열의 마지막 문자를 추가
            if(temp.length() <= 2) {
                while(temp.length() < 3){
                    temp+=temp.charAt(temp.length()-1);
                }
            }

            answer = temp;
            System.out.println("answer : " + answer);
        }
    }
}
