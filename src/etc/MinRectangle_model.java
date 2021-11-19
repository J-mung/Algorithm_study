package etc;

public class MinRectangle_model {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50},
                {30, 70},
                {60, 30},
                {80, 40}};
        int length = 0;
        int height = 0;
        
        for (int[] card : sizes) {
            // 명함 조건 : 가로 > 세로
            // 사이즈 쌍 중에서 큰 값은 가로로, 작은 값은 세로로 사용
            // 가로끼리의 가장 큰 값과 세로끼리의 가장 큰 값을 구함       -> 따로 정렬할 필요가 없어짐
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        
        int answer = length * height;
        System.out.println(answer);
    }
}
