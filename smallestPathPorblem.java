// You are given a graph, a source vertex, and a destination vertex.

// You are also given a number named "criteria" and a number "k".

// You are required to find and print the values of the Smallest path and its weight separated by an "@", just the Larger path (than criteria in terms of weight), also known as ceil path, and its weight separated by an "@" and finally Kth largest path, and it's weight separated by an "@".

// Input Format
// Input has been managed for you.

// Output Format
// Output has been managed for you. You just need to give correct values to the variables already initialized for you.

// Example 1
// Input

// 7
// 9
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// 2 5 5
// 0
// 6
// 30
// 4
// Output

// Smallest Path = 01256@28
// Just Larger Path than 30 = 012546@36
// 4th largest path = 03456@48
// Explanation

// All required answers are printed.
// Example 2
// Input

// 7
// 9
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// 2 5 5
// 0
// 5
// 30
// 2
// Output

// Smallest Path = 0125@25
// Just Larger Path than 30 = 012345@35
// 2th largest path = 03465@53
// Explanation

// All required answers are printed.
// Constraints
// 2 <= Number of vertices <= 55

// 1 <= weight of vertices <= 100


import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   static class Pair implements Comparable<Pair> {
      int wsf;
      String psf;

      Pair(int wsf, String psf){
         this.wsf = wsf;
         this.psf = psf;
      }

      public int compareTo(Pair o){
         return this.wsf - o.wsf;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      int criteria = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
      multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

      System.out.println("Smallest Path = " + spath + "@" + spathwt);
      System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
   }

   //Solution

   static String spath;
   static Integer spathwt = Integer.MAX_VALUE;
   static String cpath;
   static Integer cpathwt = Integer.MAX_VALUE;
   static PriorityQueue<Pair> pq = new PriorityQueue<>();
   public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] path, int criteria, int k, String psf, int wsf) {
      //Write code here
      //All Variables have been initialized above the function.
	   
	   if(src == dest){
		   if(wsf < spathwt){
			   spathwt = wsf;
			   spath = psf;
		   }
		   if(wsf > criteria){
			   if(wsf < cpathwt){
				   cpathwt = wsf;
				   cpath = psf;
			   }
		   }
		   pq.add(new Pair(wsf, psf));
		   if(pq.size() > k) pq.remove();
		   return;
	   }
	   
	   path[src] = true;

	   for(Edge e: graph[src]){
		   int nbr = e.nbr;
		   int wt = e.wt;

		   if(path[nbr] == false) multisolver( graph,  nbr, dest, path, criteria,  k,  psf+nbr,  wsf+wt);
	   }
	   path[src] = false;
   }
}