package etc;

public class Palindrome {
    public static void main(String[] args) {

        System.out.println(myFunc(1, 500000));
        System.out.println(reverWord(1, 500000));
    }

    public static int myFunc(int n, int m) {
        int answer = 0;
        for (int i = n; i < m; i++) {
            String tmp = String.valueOf(i);
            int length = tmp.length();
            answer++;

            for (int j = 0; j < length; j++) {
                char x = tmp.charAt(j);
                char y = tmp.charAt(length - 1 - j);

                if (x != y) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    public static int reverWord(int n, int m) {
        int answer = 0;

        for (int i = n; i < m; i++) {
            String tmp = i + "";
            StringBuffer sb = new StringBuffer(tmp);
            String revers = sb.reverse().toString();

            answer++;

            if (!tmp.equals(revers)) {
                answer--;
            }
        }
        return answer;
    }
}
