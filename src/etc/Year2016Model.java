package etc;

import java.time.LocalDate;

public class Year2016Model {
    public static void main(String[] args) {
        int a = 5, b = 24;

        // java 라이브러리를 활용
        System.out.println(LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3));
    }
}
