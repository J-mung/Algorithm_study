package SwExpertAcademy.Diff1;

import java.util.Scanner;

public class Stamp_2046 {
    static Calendar_2056_model_1 test;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            System.out.print("#");
        }

        // kotlin의 Companion Object
        // static 키워드로 정의된 멤버가 변수에 할당되서 접근이 불가능한지 아닌지에 대해 알아보는 코드
        // https://www.bsidesoft.com/8187
        Calendar_2056_model_1 comp1 = test;
        Calendar_2056_model_1 comp2 = test;
        System.out.println(comp1.getDay(1));
        System.out.println(comp2.toString());
    }
}
