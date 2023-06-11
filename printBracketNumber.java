
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.barcketNumbers(S);
            for(int value :  result)
            System.out.print(value + " ");
            System.out.println();
        
    }
}


class Solution{
	ArrayList<Integer> barcketNumbers(String S) {
        // code here
		
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		int count =1;

		for (int i=0; i<S.length(); i++){
			if(S.charAt(i) == '('){
				ans.add(count);
				st.push(count);
				count++;
			}
			else if(S.charAt(i) == ')'){
				if(st.size() >0){
					ans.add(st.pop());
				}
			}
		}
		return ans;
	}
}







