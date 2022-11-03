class Solution {
public int longestPalindrome(String[] words) {
   int result = 0;//store final answer
   int freq[][] = new int[26][26];//for keeping frequency of all words
   
    for (String s: words) {// iterating over all words
        int i = s.charAt(0) - 'a';// first char
		int j = s.charAt(1) - 'a';// second char
        if (freq[j][i] > 0) {// if reverse word have atleast one frequency
            result += 4; //then we got one pair so add 4
            freq[j][i]--; // one pair is found so decrement freq by only 1 as we haven't added [i][j]th word yet.
        }else{
			freq[i][j]++;// if no pair found then increment frequency
		}	
    }
	
    for (int i = 0; i < 26; i++) {
        if (freq[i][i] > 0) {// [i][i] index bcz every similar word will be at diagonal position
            result += 2;
            break; //if more similar words are added then our string will not be a palindrome
        }
    }
    return result;
}
}