class MedianFinder {

    ArrayList<Integer> al=new ArrayList<>();
    
    
    public MedianFinder() {
             
    }
    
    public void addNum(int num) {
       if(al.size() == 0) al.add(0, num);  
        else{
            int i=0;
            while(al.get(i) <= num && i<al.size()-1) i++;
            if(al.get(i) <= num) al.add(i+1, num);
            else al.add(i, num);
        }
    }
    
    public double findMedian() {
     
        if(al.size()%2==0){
            int val=al.size()/2;
            int val2=val-1;
           // System.out.println((al.get(val)+al.get(val2))/2);
            double result=(double)(al.get(val)+al.get(val2))/2;
            return result;
        }else{
              int val=al.size()/2;
              double result=al.get(val);
            return result;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */