package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    static class Edge{
        int src; // source
        int des; //destination
       
        public Edge(int src, int des){
            this.src = src;
            this.des = des;
            
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6,5));
    }
    // BFS
    public static void bfs(ArrayList<Edge> graph[], int v, boolean arr[], int s){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(s);
        
        while(!q.isEmpty()){
            int curr = q.remove();
            if(arr[curr]==false){
                System.out.print(curr+" ");
                arr[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }
   
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean arr[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(arr[i]==false){
                bfs(graph, v,arr, i);
            }
        }
        
        
    } 
}
