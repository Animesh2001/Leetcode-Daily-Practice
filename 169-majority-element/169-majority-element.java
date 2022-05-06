class Solution {
    public int majorityElement(int[] arr){
    int value=arr[0];
        int count=1;
        
        //we checked using Moore's voting algorithm
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=value){
                count--;
            }
            else{
                count++;
            }
            if(count==0){
                value=arr[i];
                count=1;
            }
        }
        
        //as it mentioned :- You may assume that the majority element always exists in the array.
        //return value; 
        
        //or do the below steps
        
        if(count==0){
            return -1;
        }
        
        count=0;
        for(int i=0;i<arr.length;i++){
            if(value==arr[i]){
                count++;
            }
        }
        
        return count>arr.length/2?value:-1;
}
}