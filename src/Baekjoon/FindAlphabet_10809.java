package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAlphabet_10809 {

    private final static int LENGTH = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alph = new int[LENGTH];

        for(int i = 0; i < LENGTH; i++) {
            alph[i] = -1;
        }

        int position = 0;
        for(byte val : str.getBytes()) {
            if(alph[val - 'a'] == -1)
                alph[val - 'a'] = position;
            position++;
        }

        for(int val : alph) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
