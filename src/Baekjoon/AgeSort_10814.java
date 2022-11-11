package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class AgeSort_10814 {
    private static Person[] list;
    //private static String[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new Person[N];
        //list = new String[N][2];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
            //list[i][0] = st.nextToken();
            //list[i][1] = st.nextToken();
        }
        Arrays.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        /*
        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        */
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++) {
            sb.append(list[i]); // 객체배열의 객체를 출력하면 해당 인덱스의 객체의 toString()이 출력  됨
            //sb.append(list[i][0] + " " + list[i][1] + "\n");
        }
        System.out.println(sb);
    }

    static class Person {
        int age;
        String name;

        Person() {
            age = 0;
            name = null;
        }

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() { return age; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }
}
