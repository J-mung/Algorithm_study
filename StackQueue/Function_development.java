package com.company;

public class Function_development {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int length = progresses.length;
        int[] temp = new int[length];
        int front = 0, idx = 0;

        while(front < length) {
            for(int i = 0; i < length; i++) {
                progresses[i] += speeds[i];
            }
            if(progresses[front] < 100)
                continue;
            while(front < length && progresses[front] >= 100) {
                temp[idx]++;
                front++;
            }
            idx++;
        }
        int answer[] = new int[idx];
        for(int i = 0; i < idx; i++) {
            answer[i] = temp[i];
            System.out.print(temp[i] + " ");
        }
    }
}
