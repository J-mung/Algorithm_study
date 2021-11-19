package Kakao;

public class StringCompression_model {
    public static void main(String[] args) {
        StringCompression_model SC = new StringCompression_model();
        SC.solution("abcabcdede");
    }
    public int solution(String s) {
        int answer = 0;

        // 압축 단위를 1씩 증가하면서 반복
        // 단위 >= s.length / 2 + 1 의 경우 압축률이 떨어지므로 정지
        for(int i=1; i<=(s.length()/2)+1; i++) {
            int result = getSplitedLength(s, i, 1).length();
            answer = i == 1 ? result : (answer > result ? result : answer);
            System.out.println("#"+ i + " answer:"+answer);
        }
        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat ==1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }
        
        // 일치 -> repeat+1을 한다음 재귀
        return result += getSplitedLength(postString, n, repeat+1);
    }
}
