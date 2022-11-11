package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_1_24479 {
    int[] answer;
    int tmp_answer = 0;
    ArrayList<Integer>[] edges;
    int idx = 0;
    boolean[] v;

    private void dfs(int cur) {
        //answer[cur] = ++idx;
        tmp_answer++;
        for(int next : edges[cur]) {
            if(v[next]) continue;
            v[next] = true;
            dfs(next);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //int r = Integer.parseInt(st.nextToken());
        int r = 1;
        edges = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        answer = new int[n+1];
        v = new boolean[n+1];

        while(m --> 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        // 오름차순
        for(int i = 1; i <= n; i++)
            Collections.sort(edges[i]);
        /*
        // 내림차순
        for(int i = 1; i <= n; i++)
            Collections.sort(edges[i], Collections.reverseOrder());
        */
        v[r] = true;
        dfs(r);
        //bfs(r);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append(answer[i]).append('\n');
        System.out.println(tmp_answer);
    }

    private void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);

        v[cur] = true;

        int cnt = 0;
        while(!queue.isEmpty()) {
            int q = queue.poll();
            cnt++;
            answer[q] = cnt;

            for(int i : edges[q]) {
                if(!v[i]) {
                    v[i]=true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new DFS_1_24479().solution();
    }

}
