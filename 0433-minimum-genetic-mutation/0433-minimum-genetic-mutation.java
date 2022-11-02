class Solution {
    
    public boolean check(String str1, String str2){
        int count=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                count++;
            }
        }
        return count==1;
    }
    
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String,List<String>>adj = new HashMap<>();
        HashMap<String,Integer>visited=new HashMap<>();
        if(bank.length==0)return -1;
        for(int i=0;i<bank.length;i++){
            for(int j=i+1;j<bank.length;j++){
                if(check(bank[i],bank[j])){
                    if(adj.containsKey(bank[i])){
                        adj.get(bank[i]).add(bank[j]);
                    }else{
                        List<String>list=new ArrayList<>();
                        list.add(bank[j]);
                        adj.put(bank[i],list);
                    }
                    if(adj.containsKey(bank[j])){
                      adj.get(bank[j]).add(bank[i]);
                    }else{
                        List<String>list=new ArrayList<>();
                        list.add(bank[i]);
                        adj.put(bank[j],list);
                    }
                }
            }
        }
        
        for(int i=0;i<bank.length;i++){
            if(check(bank[i],start)){
                        if(adj.containsKey(bank[i])){
                            adj.get(bank[i]).add(start);
                        }else{
                            List<String>list=new ArrayList<>();
                            list.add(start);
                            adj.put(bank[i],list);
                        }
                        if(adj.containsKey(start)){
                          adj.get(start).add(bank[i]);
                        }else{
                            List<String>list=new ArrayList<>();
                            list.add(bank[i]);
                            adj.put(start,list);
                        }
            }
        }
        
        Queue<String>queue=new LinkedList<>();
        
        queue.add(start);
        visited.put(start,1);
        
        int count=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size!=0){
                String str = queue.poll();
                if(str.equals(end)){
                    return count;
                }
                for(String i:adj.get(str)){
                    if(!visited.containsKey(i)){
                        queue.add(i);
                        visited.put(i,1);
                    }
                }
                size--;
            }
            count++;
        }
        
        return -1;
    }
}