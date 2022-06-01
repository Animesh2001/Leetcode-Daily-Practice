// { Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}


// } Driver Code Ends


class Solution
{
    void merge(int arr[], int s, int mid, int e)
    {
         // Your code here
         int size1 = mid-s+1;
         int size2 = e-mid;
         
         int arr1[]=new int[size1];
         int arr2[]=new int[size2];
         
         int k=s;
         for(int i=0;i<size1;){
             arr1[i++]=arr[k++];
         }
         k=mid+1;
         for(int j=0;j<size2;){
             arr2[j++]=arr[k++];
         }
         
         int i=0,j=0,index=s;
         while(i<arr1.length&&j<arr2.length){
             if(arr1[i]<arr2[j]){
                 arr[index++]=arr1[i++];
             }else{
                 arr[index++]=arr2[j++];
             }
         }
         while(i<arr1.length){
             arr[index++]=arr1[i++];
         }
         
         while(j<arr2.length){
             arr[index++]=arr2[j++];
         }
         
         
    }
    void mergeSort(int arr[], int s, int e)
    {
        //code here
        if(s>=e){
            return ;
        }
        int mid = s+(e-s)/2;
        
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);
        
    }
}
