package Programmers;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // find maximum value
        // and count them
        Collections.sort(candles);

        /*
        String temp = candles.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "));

        List<String> temp = candles.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.toList());

        System.out.println(temp);
        */
        int result = candles.indexOf(candles.get(candles.size() - 1));

        result = candles.size() - result;

        return result;
    }
    public static final class Companion{
        public final String method() {
            return "mimi";
        }
    }

}

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder buffer = new StringBuilder();

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        buffer.append(Result.birthdayCakeCandles(candles));
        System.out.println(buffer);

        bufferedReader.close();
        Result.Companion com = new Result.Companion();
        System.out.println(com.method());
    }
}

