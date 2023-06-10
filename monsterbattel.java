import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] health = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            health[i] = Integer.parseInt(line[i]);
        }
        Solution ob = new Solution();
        System.out.println(ob.minAttacksNeeded(health, k));
    }
}

class Solution {
    public static int minAttacksNeeded(int[] health, int k) {
		int attacks =0;
		while(health[k] >0){
			for(int i=0; i<health.length; i++){
				if(health[i] >0){
					attacks++;
					health[i]--;
				}
				if(health[k] == 0){
					return attacks;
				}
			}
		}
		return 0; // dummy
    }
}