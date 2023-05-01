class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double avg = 0;
        for(int i=1;i<salary.length-1; i++){
            avg+= salary[i];
        }
        
        double ans = (double)(avg/(salary.length-2));
        
        return ans;
    }
}