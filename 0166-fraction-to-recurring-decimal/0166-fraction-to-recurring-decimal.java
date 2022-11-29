class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)return "0";
        StringBuilder sb = new StringBuilder();
        if(numerator<0&&denominator>0 || numerator>0&&denominator<0){
            sb.append("-");
        }
        
        long num = (long)Math.abs((long)numerator);
        long den = (long)Math.abs((long)denominator);
        
        long remainder = num%den;
        sb.append(num/den);
        
        if(remainder == 0){
            return sb.toString();
        }
        
        sb.append('.');
        
        Map<Long,Integer>map=new HashMap<>();
        while(remainder!=0){
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder),"(");
                sb.append(')');
                break;
            }
            
            map.put(remainder,sb.length());
            remainder*=10;
            sb.append(remainder/den);
            remainder%=den;
        }
        
        return sb.toString();
    }
}