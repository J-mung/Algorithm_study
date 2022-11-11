package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class XorSet_1269 {
    private final static int MAX = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        BitSet setA = new BitSet(MAX);
        BitSet setB = new BitSet(MAX);

        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int bitIdx = Integer.parseInt(tokens.nextToken());
            setA.set(bitIdx, true);
        }

        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int bitIdx = Integer.parseInt(tokens.nextToken());
            setB.set(bitIdx, true);
        }
        setA.xor(setB);
        int result = setA.cardinality();

        System.out.println(result);
    }
}
