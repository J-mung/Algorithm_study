package SwExpertAcademy.Diff3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    [설명]
    1차원 초원이 있었다.

    ................

    여기에 공을 몇 개 놓았다. 공은 열린 괄호와 닫힌 괄호가 붙어 있는 ‘()’로 표현되며, 서로 다른 두 공이 겹치지 않는다.

    ...()..()()...().

    여기에 잡초가 자라서 몇 개의 칸이 가려지게 되었다. 잡초는 ‘|’로 표현된다.

    |..(|.||)||||.().

    위와 같은 과정을 통해 얻어진 문자열이 주어진다. 이때, 초원에 놓았을 수 있는 공의 개수의 최솟값을 구하는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스는 한 개의 줄로 이루어지며, 각 줄에는 길이가 1이상 50 이하인 문자열 S가 주어진다.

    이 문자열은 위의 과정을 통해 만들어졌음이 보장된다.

    3
    ||||||
    (|..|)
    .|.(|...||)|...()..

    [출력]
    각 테스트 케이스마다, 초원에 놓였을 수 있는 공의 개수의 최솟값을 구하는 프로그램을 작성하라.

    #1 0
    #2 2
    #3 3

    ******************************************
    잡초가 자라기 이전에 이미 공은 놓아져 있었다.
    따라서 "(|" 과 "|)"도 하나의 공이다.
    ******************************************
*/


public class BallAndWeed_14555 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            sb.append('#').append(t).append(' ');
            char ch[] = br.readLine().toCharArray();
            char temp = ch[0];
            int result = 0;

            int len = ch.length;
            for(int i=1; i<len; i++) {
                String str = Character.toString(temp) + Character.toString(ch[i]);

                if( str.equals("(|") || str.equals("|)") ) {
                    result++;
                }
                else if( str.equals("()") ) result++;

                temp = ch[i];
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString()); bw.flush(); bw.close();
    } // End of main
}
