package SwExpertAcademy.Diff1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddEachNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = value; i > 0; i = i / 10) {
            result += i % 10;
        }

        System.out.println(result);
    }
}
