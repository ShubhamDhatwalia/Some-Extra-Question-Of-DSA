// Maximum Sum
// You are given an array A of N integers. You are also given another array ops describing operations where ops[i] = (l, r). l and r are 0-indexed. For every pair in ops calculate the sum of A[l] + A[l+1] +...+ A[r-1] + A[r].

// Your score is the sum of all the answers from ops. You have to find the maximum score possible, if you can arrange the array A in any order.

// The answer can be very large, so return it modulo 1000000007.

// Note Complete the given function. The input and output would be handled by the driver code.

// Input Format
// The first line contains a single integer N.

// The second line contains N space-separated integers of array A.

// The next line contains a single integer M denoting the size of ops.

// The next M lines contain two integers each, of the array ops.

// Output Format
// Print the answer in a new line.

// Example 1
// Input

// 5
// 2 1 3 5 4
// 2
// 0 1
// 1 2
// Output

// 17
// Explanation

// The permutation [3, 5, 4, 1, 2] is one of the answers that yield maximum sum.

// A[0] + A[1] = 8.

// A[1] + A[2] = 9.

// 8 + 9 = 17.

// Example 2
// Input

// 4
// 2 3 5 4
// 2
// 0 1
// 1 3
// Output

// 19
// Explanation

// The permutation [3, 5, 4, 2] is one of the answers that yield maximum sum.

// A[0] + A[1] = 8.

// A[1] + A[2] + A[2]= 11.

// 8 + 11 = 19.

// Constraints
// 1 <= N <= 10000

// 1 <= A[i] <= 10000

// 1 <= M <= 10000

// 0 <= ops[i][j] < N




import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {
		int mod = 1000000007;
		int pref [] = new int[A.length];

		for(int [] op : ops){
			int sp = op[0];
			int ep = op[1];

			pref[sp] += 1;
			if(ep < A.length-1) pref[ep+1] -= 1;
		}
		for(int i=1; i<A.length; i++){
			pref[i] = (pref[i] + pref[i-1]);
		}
		Arrays.sort(pref);
		Arrays.sort(A);

		int ans =0;
		for(int i=0; i<A.length; i++){
			ans = ( ans + A[i] * pref[i])%mod;
		}
		return ans;
    }
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}


