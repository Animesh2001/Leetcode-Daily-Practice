class Solution {
    public int minBitFlips(int start, int goal) {
        int flipped = start^goal;
        int count=0;
        while(flipped!=0){
            int rmsb = (flipped & -flipped);
            flipped-=rmsb;
            count++;
        }
        return count;
    }
}