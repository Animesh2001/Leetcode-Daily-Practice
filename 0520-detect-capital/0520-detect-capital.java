class Solution {

    public boolean detectCapitalUse(String word) {
        char arr[] = word.toCharArray();
        boolean ans = true;

        //if first character is capital
        if (arr[0] >= 65 && arr[0] <= 90) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] >= 97 && arr[i] <= 122) {
                    //if remaining characters are capital
                    ans = false;
                    break;
                }
            }
            if (ans == false) {
                ans = true;
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] >= 65 && arr[i] <= 90) {
                        //if remaining characters are small
                        ans = false;
                        break;
                    }
                }
            }
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] >= 65 && arr[i] <= 90) {
                    ans = false;
                    break;
                }
            }
        }

        return ans;
    }
}
