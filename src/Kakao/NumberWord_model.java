package Kakao;

public class NumberWord_model {
    public static void main(String[] agrs) {
        int answer = 0;
        String test = "two2foursix";
        // 영단어에 대응되는 숫자
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        // 영단어
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        // 0부터 9까지 영단어를 숫자로 변경
        for(int i = 0; i < 10; i++) {
            // replaceAll로 한 번에 치환
            test = test.replaceAll(word[i], digits[i]);
        }

        answer = Integer.parseInt(test);
        System.out.println("answer : " + answer);

    }
}
