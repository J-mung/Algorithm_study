package SwExpertAcademy.Diff1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

public class Calendar_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String date = br.readLine();
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);

            if (month.equals("02") && Integer.parseInt(day) > 28)
                day = "00";
            String reformat = year + "-" + month + "-" + day;
            System.out.print("#" + (i + 1) + " ");
            try {
                System.out.println(Date.valueOf(reformat).toString().replaceAll("-", "/"));
            } catch(Exception e) {
                System.out.println(-1);
            }
        }

    }
}
