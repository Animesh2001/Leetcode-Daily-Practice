class Solution {
    
    class Pair{
        int val;
        int index;
        
        public Pair(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    
    public long totalCost(int[] costs, int k, int candidates) {
         PriorityQueue<Pair>pq1=new PriorityQueue<>((Pair a,Pair b)->{
             if(a.val!=b.val){
                 return a.val-b.val;
             }else{
                 return a.index-b.index;
             }
         });
         PriorityQueue<Pair>pq2=new PriorityQueue<>((Pair a,Pair b)->{
             if(a.val!=b.val){
                 return a.val-b.val;
             }else{
                 return a.index-b.index;
             }
         });
        
        int i = 0, j = costs.length-1;
        
        while(i<costs.length&&i<candidates){
            pq1.add(new Pair(costs[i],i));
            i++;
        }
        
        int l=0;
        while(j>=0&&j>=i&&l<candidates){
            pq2.add(new Pair(costs[j],j));
            j--;
            l++;
        }
        
        int count=0;
        long cost = 0;
        
        while(i<=j&&count<k){
            Pair temp1 = pq1.peek();
            Pair temp2 = pq2.peek();
            
            if(temp1.val==temp2.val){
                if(temp1.index<temp2.index){
                    cost+=temp1.val;
                    // System.out.println(temp1.val);
                    pq1.remove();
                    // if(i<j)
                    pq1.add(new Pair(costs[i],i));
                    i++;
                }else{
                    cost+=temp2.val;
                     // System.out.println(temp2.val);
                    pq2.remove();
                    pq2.add(new Pair(costs[j],j));
                    j--;
                }
            }
            
            else if(temp1.val<temp2.val){
                    cost+=temp1.val;
                    // System.out.println(temp1.val);
                    pq1.remove();
                    
                    // if(i<j)
                    pq1.add(new Pair(costs[i],i));
                i++;
            }
            else{
                    cost+=temp2.val;
                    // System.out.println(temp2.val);
                    pq2.remove();
                    // if(i<j)
                    pq2.add(new Pair(costs[j],j));
                j--;
            }
            count++;
        }
        
        if(count<k){
                while(!pq2.isEmpty()){
                pq1.add(pq2.poll());
            }

            while(count<k){
                cost+=pq1.peek().val;
                // System.out.println(pq1.peek().val);
                pq1.remove();
                count++;
            }
        }
        
        
        return cost;
        
        
         
        
         
    }
}