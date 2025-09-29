package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BfsSearch{
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

        bfs(graph, 0, new boolean[n]);
        scanner.close();
    }

    /**
     * bfs广度优先遍历图
     * @param graph 图
     * @param start 当前访问的节点
     * @param isVisit 记录是否遍历过
     */
    private static void bfs(List<Integer>[] graph, int start, boolean[] isVisit){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 从第一个元素开始层序遍历
        pq.add(start);

        // 层序遍历
        while(!pq.isEmpty()){
            int index = pq.poll();

            if(isVisit[index])
                continue;

            isVisit[index] = true;

            System.out.println("visited - " + index);

            // 对每一个孩子节点加入优先队列中
            for(int children : graph[index]){
                if(!isVisit[children])
                    pq.add(children);
            }
        }
    }
}
