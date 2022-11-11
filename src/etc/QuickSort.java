package etc;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    private static final int MAX = 10;
    private static int[] origin;
    public static void main(String[] args) {

        Random random = new Random();
        origin = new int[MAX];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < MAX; i++) {
            //origin[i] = random.nextInt(100);
            origin[i] = sc.nextInt();
            //System.out.println(origin[i]);
        }

        quickMiddle(0, MAX-1);

        StringBuffer result = new StringBuffer();
        for(int i = 0; i < MAX; i++) {
            if(i % 10 == 0)
                result.append("\n");
            result.append(origin[i] + " ");
        }

        System.out.println(result);
    }

    public static void quick(int start, int end) {
        if(start < end) {
            int p = partitionRight(start, end);
            quick(start, p-1);
            quick(p+1, end);
        }
    }

    private static int partitionRight(int p, int r) {
        int pivot = origin[r];
        int left = p - 1;
        for(int right = p; right < r; right++) {
            if(origin[right] <= pivot){
                swap(++left, right);
            }
        }
        swap(left+1, r);
        return left+1;
    }

    public static void quickLeft(int start, int end) {
        if(start < end) {
            int p = partitionLeft(start, end);
            quick(start, p-1);
            quick(p+1, end);
        }
    }

    private static int partitionLeft(int p, int r) {
        int pivot = origin[p];
        int left = p;
        for(int right = p+1; right<=r; right++) {
            if(origin[right] <= pivot) {
                swap(++left, right);
            }
        }
        swap(p, left);
        return left;
    }

    private static void quickMiddle(int start, int end) {
        if(start < end) {
            int p = partitionMiddle(start, end);
            quickMiddle(start, p);
            quickMiddle(p+1, end);
        }
    }

    // 중복되는 정수들이 배열에 포함되는 경우 무한 루프
    // n차 분할이 완료된 후에 피벗의 위치를 조정하지 않아서 발생하는 것으로 분석 됨
    private static int none_partitionMiddle(int start, int end) {
        int pivot = origin[(start+end)/2];
        int left = start;
        int right = end;

        while(left<right) {
            while(origin[left] < pivot) left++;
            while(origin[right] > pivot && left <= right) right--;
            if(left < right) {
                swap(left, right);
            }
        }
        return right;
    }

    private static int partitionMiddle(int start, int end) {
        int pivot = origin[(start+end)/2];
        int left = start-1;
        int right = end+1;

        while(true) {
            do{
                left++;
            }while(origin[left] < pivot);
            do{
                right--;
            } while(origin[right] > pivot && left <= right);

            if(left >= right)
                return right;

            swap(left, right);
        }
    }

    public static void swap(int x, int y) {
        int temp = origin[x];
        origin[x] = origin[y];
        origin[y] = temp;
    }
}