package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PulsAll_model {
    public static void main(String[] args) {
        int[] numbers = {2,3,4,5,6};
        HashSet<Integer> set = new HashSet<>();

        // 2개의 요소를 선택해 더해서 만들 수 있는 수를 집합에 삽입
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // set에 저장된 요소에 접근하기 위해 ArrayList화
       ArrayList<Integer> list = new ArrayList<>(set);
        // int형 배열로 전송하기 위한 배열
        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        // 오름차순 정렬
        Arrays.sort(answer);

        for(int val : answer){
            System.out.println(val);
        }
    }
}
