/*
슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만,
요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
오렐리를 위해 실패율을 구하는 코드를 완성하라.

실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가
매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을
return 하도록 solution 함수를 완성하라.

제한사항
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages의 길이는 1 이상 200,000 이하이다.
stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

입출력 예
N	stages	result
5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
4	[4,4,4,4,4]	[4,1,2,3]
 */
package Kakao;

public class FailureRate_ver2 {
    public static void main(String[] args) {
        int N = 5;                              // 스테이지 수
        int[] stages = {2,1,2,4,2,4,3,3};       // 유저가 현재 멈춰있는 스테이지 정보
        int[] answer = new int[N];              // 답 저장 배열
        int userNum = stages.length;            // 유저들의 수
        double[] failStage = new double[N];     // 실패율을 저장하는 배열

        // stages에 있는 요소를 인덱스로 사용하여
        // 해당 stage에 멈춰있는 유저들의 수를 조사
        for(int val : stages) {
            if(val <= N) {
                failStage[val-1]++;
            }
        }
        
        // 각 stage별로 멈춰있는 유저들의 수 / 전체 유저 수
        // 위의 정보가 해당 stage의 실패율이므로, 배열에 저장
        for(int idx = 0; idx < N; idx++) {
            int temp = (int)failStage[idx];     // 해당 스테이지에서 멈춘 유저 수
            failStage[idx] = (double)failStage[idx] / userNum;  // 실패율
            userNum -= temp;                    // 전체 유저 수 - 해당 스테이지에서 멈춘 유저 수
            // 만약 단 한 명의 유저도 마지막 스테이지까지 도달하지 못 했다면
            // 0 / 0을 계산하는 경우가 발생하므로 처리
            if(userNum <= 0) {
                break;
            }
        }
        
        // 실패율 확인
        for(double val : failStage) {
            System.out.println("rate : " + val + " ");
        }
        
        // 실패율이 큰 스테이지 순서대로 answer 배열에 저장
        for(int i = 0; i < N; i++) {
            double max = -1;
            int idx = 0;
            for(int j = 0; j < N; j++) {
                if(failStage[j] > max) {
                    max = failStage[j];
                    idx = j;
                }
            }
            failStage[idx] = -10;
            answer[i] = idx+1;
        }
        
        // 실패율 순서 확인
        for(double val : answer) {
            System.out.println("stage : " + val + " ");
        }
    }
}
