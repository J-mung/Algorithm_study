package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Sorting2_2751 {

    private static int[] element;
    private static final int ROOTIDX = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받을 정수의 개수
        int nums = Integer.parseInt(br.readLine());
        element = new int[nums+1];

        // 정수 입력
        for(int i = ROOTIDX; i <= nums; i++) {
            element[i] = Integer.parseInt(br.readLine());
        }

        // heap sorting
        new Sorting2_2751().heapSort();

        // oriented array print
        for(int i = 1; i < element.length; i++) {
            bw.write(String.valueOf(element[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public void heapSort() throws Exception {
        int size = element.length;
        
        // 정렬할 요소가 1개 이하일 때는 정렬할 필요가 없으므로 return
        if(size < 2)
            return;

        // 최대힙 구성을 위해 처음 정렬할 부모 노드 획득
        int parentIdx = getParent(size);

        // 최대힙 구성
        for(int i = parentIdx; i > 0; i--) {
            heapify(i, size-1);
        }

        // element 배열 자체를 heap으로 간주
        // element를 heap 및 oriented array로 나눠서 정렬
        for(int i = size-1; i > 0; i--) {
            // MAX Heap의 1번째 요소를 [size-1]로 보냄으로써 oriented array를 채움
            swap(ROOTIDX, i);
            // MAX Heap 재구성
            heapify(ROOTIDX, i-1);
        }
    }

    private int getParent(int child) {
        return (child-1) / 2 ;
    }
    private void heapify(int parentIdx, int lastIdx) {
        int leftChild;
        int rightChild;
        int swapIdx;

        while((parentIdx * 2) <= lastIdx) {
            leftChild = parentIdx * 2;
            rightChild = parentIdx * 2 + 1;
            swapIdx = parentIdx;

            if(element[leftChild] > element[swapIdx]) {
                swapIdx = leftChild;
            }

            if(rightChild <= lastIdx && element[rightChild] > element[swapIdx]) {
                swapIdx = rightChild;
            }

            if(swapIdx != parentIdx) {
                swap(parentIdx, swapIdx);
                parentIdx = swapIdx;
            } else
                return;
        }
    }

    private void swap(int x, int y) {
        int temp = element[x];
        element[x] = element[y];
        element[y] = temp;
    }

    public static int[] swap(int[] arr, int x, int y) {
        int temp = 0;

        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return arr;
    }
    
    public static void quickSort(int[] arr, int left, int right) {
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();

        lstack.push(left);
        rstack.push(right);

        while(lstack.empty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int pivot = arr[(left+right) / 2];

            do {
                while(arr[pl] < pivot) pl++;
                while(arr[pr] > pivot) pr--;

                if(pl <= pr)
                    swap(arr, pl++, pr--);
            } while(pl <= pr);

            if(left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if(pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }

    public static void quickSortRecur(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(pl+pr) / 2];

        do {
            while (arr[pl] < pivot) pl++;
            while (arr[pr] > pivot) pr--;

            if(pl <= pr)
                swap(arr, pl++, pr--);
        } while(pl <= pr);

        if(left < pr) quickSortRecur(arr, left, pr);
        if(pl < right) quickSortRecur(arr, pl, right);
    }
}