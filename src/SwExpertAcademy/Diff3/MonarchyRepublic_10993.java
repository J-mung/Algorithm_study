package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    태초에 2차원 평면에 N개의 도시가 있었다. 각 도시는 좌표 (xi, yi) 에 존재하고, si의 군사력을 보유하고 있다. 모든 도시의 위치는 다르다.

    도시 i가 다른 도시 j에 행사하는 영향력을, si / ( (xj - xi)2+(yj - yi)2 )라고 정의하자.

    즉, 이는 군사력을 두 도시의 거리 제곱으로 나눈 것이다. 만약 어떠한 도시 j가 다른 도시 i에 행사하는 영향력이 그 도시의 군사력 si 초과라면, 도시 i는 도시 j에 위협당한다.

    현재 모든 도시는 각 도시를 지배하는 군주를 모시고 있다. 이제, 이들 도시는 지정학적 상황에 따라서 통치 체제를 바꿀 것이다.



    - 만약 도시 i가 어떠한 다른 도시에도 위협당하지 않는다면, 해당 도시의 사람들은 군주를 존경하고, 도시 i는 군주제를 유지한다.
    - 만약 도시 i가 하나 이상의 도시들에 위협당하며, 이들 중 영향력이 가장 큰 도시가 유일하다 하자.
        도시 i는 항복하고, 영향력이 가장 큰 유일한 도시 j의 체제를 따른다.
        만약 위협하는 도시 j 역시 다른 도시 k에 항복했다면, 도시 k의 체제를 따르고, 이것이 계속되면 이를 반복하여 따라간다.
    - 만약 도시 i가 하나 이상의 도시들에 위협당하며, 이들 중 영향력이 가장 큰 도시가 두 개 이상이라 하자.
        도시의 사람들은 군주를 존경하지 않으며 어떤 도시에 복종해야 하는지 분열된 의견을 가진다.
        고로 도시 i는 민주적인 공화제를 도입한다.

    각 도시의 정보가 주어졌을 때, 이 도시가 군주제를 유지한다면 K, 공화제를 유지한다면 D를 출력하고, 다른 도시의 체제를 따른다면, 그 도시의 번호를 출력하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.

    각 테스트 케이스는 다음과 같이 구성되었다.

    - 첫 번째 정수는 도시의 개수 N 이다. (1 ≤ N ≤ 1000)
    - 이후 N개의 줄에 각 도시의 정보 xi, yi, si 가 주어진다. (0 ≤ xi, yi, si ≤ 1000)

    1
    5
    2 5 14
    2 3 2
    3 2 7
    1 1 2
    2 1 3

    [출력]
    각 테스트 케이스마다 한 줄에 도시 1, 2, 3, … N의 정보를 공백으로 구분하여 출력하라.

    #1 K D K 3 3

*/

public class MonarchyRepublic_10993 {
    private static int[][] cities;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int testCast = sc.nextInt();

        for (int tc = 0; tc < testCast; tc++) {
            int cityNum = sc.nextInt();
            cities = new int[cityNum][4];

            // 도시 정보 입력
            for (int j = 0; j < cityNum; j++) {

                // 도시 위치
                cities[j][0] = sc.nextInt();
                cities[j][1] = sc.nextInt();

                // 도시 군사력
                cities[j][2] = sc.nextInt();

                // 도시의 체제 군주제(-2)가 default
                cities[j][3] = -2;
            }

            double[][] power = new double[cityNum][cityNum];
            // 각 도시별 영향력
            // 가로 : 타국가에 행사하는 나의 영향력
            // 세로 : 나에게 끼치는 타국가들의 영향력
            for (int j = 0; j < cityNum; j++) {
                for (int k = 0; k < cityNum; k++) {
                    double tmp = 0;

                    if (j != k)
                        tmp = cities[j][2] / (Math.pow(cities[k][0] - cities[j][0], 2.0) + Math.pow(cities[k][1] - cities[j][1], 2.0));

                    power[j][k] = tmp;
                }
            }

            for (int i = 0; i < cityNum; i++) {
                for (int j = 0; j < cityNum; j++) {
                    System.out.format(" %.2f", power[j][i]);
                }
                System.out.println();
            }

            // i : 나
            for (int i = 0; i < cityNum; i++) {
                double curMax = Double.MIN_VALUE;

                // j : 항복해야 할 수도 있는 내 주변 도시
                for (int j = 0; j < cityNum; j++) {

                    // 도시 j가 다른 도시 i에 행사하는 영향력이 S_i를 초과하면
                    if (power[j][i] > cities[i][2]) {

                        // 항복해야 할 도시와 동일한 영향력을 행사하는 새로운 도시를 보면
                        if (power[j][i] == curMax) {
                            // 항복할 도시는 공화제(D)
                            cities[i][3] = -1;
                        }

                        // 가장 큰 영향력을 행사하는 도시가 나타나면
                        else if (power[j][i] > curMax) {

                            // 해당 도시에게 항복
                            cities[i][3] = j;
                            curMax = power[j][i];
                        }
                    }
                    /*
                    // 도시 j가 다른 도시 i에 행사하는 영향력이 S_i를 초과하면
                        if (power[j][i] > curMax) {

                            // 도시 i는 도시 j에게 항복
                            cities[i][3] = j;
                            curMax = power[j][i];
                        }
                        // =========================================================
                        // curMax는 선언과 동시에 나의 도시(i)로 초기화 됌
                        // 이때 나의 도시(i)와 동일한 영향력을 지닌 도시(j)가 나타나게 되면
                        // 공화제를 택하는 오류가 있음
                        // 항복해야 할 도시와 동일한 영향력을 행사하는 새로운 도시를 보면
                        else if (power[j][i] == curMax) {
                            // 항복할 도시는 공화제(D)
                            cities[i][3] = -1;
                        }
                        // =========================================================
                    */
                }

            }

            builder.append("#" + (tc + 1) + " ");
            for (int i = 0; i < cityNum; i++) {
                if (cities[i][3] == -2)
                    builder.append("K ");
                else if (cities[i][3] == -1)
                    builder.append("D ");
                else
                    builder.append((update(cities[i][3]) + 1) + " ");
            }
            builder.append("\n");
        }
        System.out.println(builder);

    }

    // 내가(i) 항복했던 도시(j)가 또 다른 도시(k)에게 항복했다면 갱신
    private static int update(int idx) {
        if (cities[idx][3] == -2 || cities[idx][3] == -1)
            return idx;
        else {
            cities[idx][3] = update(cities[idx][3]);
            return cities[idx][3];
        }
    }
}
