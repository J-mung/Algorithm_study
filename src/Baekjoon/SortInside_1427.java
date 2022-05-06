package Baekjoon;

import java.io.*;

public class SortInside_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int[] count = new int[10];

        for(int i = 0; i < input.length(); i++) {
            count[Integer.parseInt(String.valueOf(input.charAt(i)))]++;
        }

        for(int i = 9; i >= 0;) {
            if(count[i] != 0) {
                bw.write(String.valueOf(i));
                count[i]--;
            } else {
                i--;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
