/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
         
        int i=1, j = n;
        int answer=0;
        while(i<=j){
            int mid = i+(j-i)/2;
            int ans = guess(mid);
            if(ans<0){
                j=mid-1;
            }else if(ans>0){
                i=mid+1;
            }else{
                answer=mid;
                break;
            }
        }
        return answer;
    }
}