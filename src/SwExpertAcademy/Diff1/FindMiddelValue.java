package SwExpertAcademy.Diff1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindMiddelValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int arr[] = new int[N];

        for (int i = 1; i <= N - 1; i++) {
            int val = Integer.parseInt(tokens.nextToken());
            int j;
            for (j = i - 1; j >= 0 && arr[j] > val; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = val;
        }

        System.out.println(arr[(N / 2)]);
    }
}
