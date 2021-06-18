package etc;
import java.util.ArrayList;

public class MakePrimeNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        int answer = 0;

        // 배열에서 숫자 3개 조합해서 더하기
        for(int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    // 소수 판별
                    if(isPrimNum(temp)){
                        answer++;
                    }
                }
            }
        }
        System.out.println("answer : " + answer);
    }
    // 소수 판별 함수
    static boolean isPrimNum(int num) {
        int sqrn = (int) Math.sqrt(num);
        int div = 2;
        boolean isPrim = false;
        while (div <= sqrn && (num % div) != 0) {
            div++;
        }
        if (div > sqrn) {
            isPrim = true;
        }
        return isPrim;
    }
}