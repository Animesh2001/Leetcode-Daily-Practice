// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public static class Pair implements Comparable<Pair>{
        int price,day;
        public Pair(int price,int day){
            this.price=price;
            this.day=day;
        }
        public int compareTo(Pair p){
            return this.price-p.price;
        } 
    }
    
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        Pair pair[]=new Pair[n];
        for(int i=0;i<n;i++){
            Pair p = new Pair(price[i],i+1);
            pair[i]=p;
        }
        Arrays.sort(pair);
        int count=0;
        
        for(int i=0;i<pair.length;i++){
            int amount =pair[i].price*pair[i].day;
            if(amount<=k){
                k=k-amount;
                count+=pair[i].day;
            }
            else{
                // while(k-pair[i].price>=0){
                //     k-=pair[i].price;
                //     count++;
                // }
                // break;
                count+=k/pair[i].price;
                k=k-(pair[i].price)*(k/pair[i].price);
            }
        }
        return count;
        
    }
}
        
