import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = input.nextInt();
        }
        System.out.println(maxScore(heights));
    }

    public static int maxScore(int[] heights) {
       int nsgel [] = new int[heights.length];
		Arrays.fill(nsgel, -1);

		Stack<Integer> st = new Stack<>();
		for(int i=0; i<heights.length; i++){
			while(st.size() >0 && heights[st.peek()] < heights[i]){
				st.pop();
			}
			if(st.size() >0){
				nsgel[i] = st.peek();
			}
			st.push(i);
		}

		int ans = Integer.MIN_VALUE;
		for(int i=0; i<nsgel.length; i++){
			if(nsgel[i] == -1) continue;
			int distance = i-nsgel[i];
			int diff = heights[nsgel[i]] - heights[i];
			int score = distance* diff;
			
			ans = Math.max(ans, score);
		}
		return ans;
    }

}
