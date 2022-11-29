class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int curr_val = arr[i];
            if(map.containsKey(2*curr_val)){
                if(map.get(2*curr_val)==1){
                    map.remove(2*curr_val);
                }else{
                    map.put(2*curr_val,map.get(2*curr_val)-1);
                }
            }else if(map.containsKey(curr_val/2)&&curr_val%2==0){
               if(map.get(curr_val/2)==1){
                    map.remove(curr_val/2);
                }else{
                    map.put(curr_val/2,map.get(curr_val/2)-1);
                }
            }else{
                map.put(curr_val,map.getOrDefault(curr_val,0)+1);
            }
        }
        return map.size()==0;
    }
}