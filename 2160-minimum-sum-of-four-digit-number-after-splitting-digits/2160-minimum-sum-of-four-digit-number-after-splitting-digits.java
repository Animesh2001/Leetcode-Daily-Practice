class Solution {
    public int minimumSum(int num) {
        int arr[]=new int[4];
        for(int i=3;i>=0;i--){
            arr[i]=num%10;
            num=num/10;
        }
        Arrays.sort(arr);
        int sum1 = arr[2]+arr[3];
        int sum2 = arr[0]+arr[1];
        
        int carry = sum1/10;
        sum2+=carry;
        sum2=sum2*10;
        sum2 = sum2+(sum1%10);
        return sum2;
    }
}