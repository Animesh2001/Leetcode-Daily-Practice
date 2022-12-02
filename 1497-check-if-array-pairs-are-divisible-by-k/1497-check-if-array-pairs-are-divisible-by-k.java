class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        HashMap<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int rem = arr[i]%k;
            if(rem<0)rem+=k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        for(int num:map.keySet()){
            if(num==0){
                if(map.get(num)%2!=0) return false;
            }else{
                if(!map.get(num).equals(map.getOrDefault(k-num,0)))return false;
            }
        }
        
        return true;
        
    }
}