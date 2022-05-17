// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        
        // Explanation
        // 1. sort the Job array according to profit in descending order
        // 2. make an array with max deadline + 1
        // 3. complete the deadline work at last so that more work can be done before that
        // 4. watch abdul bari's video once.
        
        
        // Your code here
        
        // Arrays.sort(arr,(o1,o2)->{
        //   return o2.profit-o1.profit; 
        // });
        
        //OR
        //ALERT------------------------
        //In short
        Arrays.sort(arr,(o1,o2)->(o2.profit-o1.profit));
        
        
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxi=Math.max(maxi,arr[i].deadline);
        }
        
        int result[]=new int[maxi+1];
        
        for(int i=0;i<=maxi;i++){
            result[i]=-1;
        }
        int count=0;
        int profit=0;
        for(int i=0;i<arr.length;i++){
                int j=arr[i].deadline;
                while(j>0){
                    if(result[j]==-1){
                        result[j]=arr[i].id;
                        count++;
                        profit+=arr[i].profit;
                        break;
                    }
                    j--;
                }
            }
        int ans[]=new int[2];
        ans[0]=count;
        ans[1]=profit;
        return ans;
    }
}