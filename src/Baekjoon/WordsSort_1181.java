package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordsSort_1181 {
    private static Word[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        words = new Word[N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            words[i] = new Word(str);
        }

        for(int i = 1; i < N; i++) {
            int j = i - 1;
            Word temp = words[i];
            while(j >= 0 && words[j].compareTo(temp) > 0) {
                words[j+1] = words[j];
                j--;
            }
            words[j+1] = temp;
        }

        Word previous = words[0];
        System.out.println(words[0].getStr());
        for(int i = 0; i < N; i++) {
            if(previous.getStr().equals(words[i].getStr()))
                continue;
            System.out.println(words[i].getStr());
            previous = words[i];
        }
    }
    static class Word implements Comparable<Word>{
        String str;
        int value;

        Word(String str) {
            this.str = str;
            int value = 0;

            for(byte val : str.getBytes()) {
                value += val;
            }

            this.value = value;
        }

        String getStr() {
            return this.str;
        }

        @Override
        public int compareTo(Word o) {
            if(this.str.length() == o.str.length()) {
                int idx = 0;
                while(this.str.charAt(idx) == o.str.charAt(idx)) {
                    idx++;
                    if(idx >= this.str.length()) {
                        idx--;
                        break;
                    }
                }
                return this.str.charAt(idx) - o.str.charAt(idx);
            } else {
                return this.str.length() - o.str.length();
            }
        }
    }
}
