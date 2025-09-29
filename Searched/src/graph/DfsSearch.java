package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DfsSearch{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        /*
        testing
        6 8
        0 1
        0 2
        0 3
        1 4
        2 5
        2 3
        3 5
        4 5
         */
        for(int i = 0;i<m;i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            graph[start].add(end);
        }

        dfs(graph, 0, new boolean[n]);
        scanner.close();
    }

    /**
     * dfs深度优先遍历图
     * @param graph 图
     * @param start 当前访问的节点
     * @param isVisit 记录是否遍历过
     */
    private static void dfs(List<Integer>[] graph, int start, boolean[] isVisit){
        // 非合法
        if(start >= graph.length || start < 0 || isVisit[start])
            return;

        // 访问过当前位置了
        isVisit[start] = true;
        System.out.println("visited - " + start);

        for(int children : graph[start]){
            // 遍历每一个邻居节点
            dfs(graph, children, isVisit);
        }
    }
}
