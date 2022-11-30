class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Map<Integer,Integer>present=new HashMap<>();
        for(int val : map.values()){
            if(present.containsKey(val)){
                return false;
            }
            present.put(val,1);
        }
        return true;
    }
}