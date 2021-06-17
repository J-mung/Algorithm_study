/*
다음은 카카오 아이디의 규칙입니다.

아이디의 길이는 3자 이상 15자 이하여야 합니다.
아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

[입출력 예]
no	new_id	result
예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
예2	"z-+.^."	"z--"
예3	"=.="	"aaa"
예4	"123_.def"	"123_.def"
예5	"abcdefghijklmn.p"	"abcdefghijklmn"

 */
package Kakao;

public class Recommand_id {
    public static void main(String args[]) {
        String new_id = "=.=";
        Inspection inspection = new Inspection();
        int idx = 0;

        // 1단계. 모든 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2단계. 지정된 문자를 제외한 특수문자 제외
        while(idx < new_id.length()) {
            if(!inspection.isAlphabet(new_id, idx) && !inspection.isNumber(new_id, idx)) {
                if (inspection.isExcept(new_id, idx)) {
                    new_id = new_id.substring(0, idx) + new_id.substring(idx + 1);
                    idx-=1;
                }
            }
            // 3단계. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 처리
            if(idx >= 1 && new_id.charAt(idx)=='.' && new_id.charAt(idx-1)=='.') {
                new_id = new_id.substring(0, idx) + new_id.substring(idx + 1);
                idx-=1;
            }
            idx++;
        }

        // 4단계. 첫 문자와 끝 문자가 마침표(.)이면 제거
        if(new_id.charAt(0) == '.') {
            new_id = new_id.substring(0,0) + new_id.substring(1);
        }
        if(!inspection.isEmpty(new_id) && new_id.charAt(new_id.length()-1) == '.') {
            new_id = new_id.substring(0,new_id.length()-1);
        }

        // 5단계. 빈 문자열이라면, a 문자 대입
        if(inspection.isEmpty(new_id)) {
            new_id = "a";
        }

        // 6단계. 문자열의 길이가 16자 이상이면, 첫 15개의 문자만 남김
        //       만약 제거 후 마침표(.)가 문자열 양 끝에 위치하면 제거
        if(new_id.length() >= 16) {
            new_id = (String) new_id.subSequence(0, 15);
        }
        if(new_id.charAt(new_id.length()-1) == '.') {
            new_id = new_id.substring(0,new_id.length()-1);
        }

        // 7단계. 문자열 길이가 2자 이하라면, 문자열의 마지막 문자를 문자열의 길이가 3이 될 때까지 반복해서 끝에 붙임
        while(new_id.length() <= 2) {
            new_id = new_id + new_id.charAt(new_id.length()-1);
        }
        System.out.println(new_id);
    }
}

class Inspection {
    boolean isEmpty(String check) {
        return check.length() <= 0 ? true : false;
    }
    boolean isAlphabet(String check, int idx) {
        return check.charAt(idx) >= 'a' && check.charAt(idx) <= 'z' ? true : false;
    }
    boolean isNumber(String check, int idx) {
        return check.charAt(idx) >= '0' && check.charAt(idx) <= '9' ? true : false;
    }
    boolean isExcept(String check, int idx) {
        return check.charAt(idx) != '-' && check.charAt(idx) != '_' && check.charAt(idx) != '.' ? true : false;
    }
}