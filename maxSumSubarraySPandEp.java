import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int arr[],int n){
        //Write code here
		//TC o(N)
		//sc o(1)
		long train =0;
        long maxi =Integer.MIN_VALUE;
        int os =0;
        int oe =0;
        int cs =-1;
        int ce =-1;

        for(int i=0; i<n; i++){
            long newtrain= arr[i];
            long prevtrain = train+newtrain;

            if(newtrain > prevtrain){
                cs =i;
                train = newtrain;
            }else{
                train = prevtrain;
            }
            if(train > maxi){
                os =cs; oe =ce;
                maxi = train;
            }
            ce++;
        }
        System.out.println(os +" " +oe);
        return maxi;
    }
}

// 2 -3 4 5 -10 2 6 8 -4 3 2 -1 2 -7 3









