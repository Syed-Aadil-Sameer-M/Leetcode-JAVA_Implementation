class Solution {
    public boolean isPalindrome(int x) {
        boolean flag = false;
        int reversed = 0;
        int ori= x;
        int digit = 0;
        if (ori<0) {
            return flag;
        }

        else if (ori>=0 && ori<=9) {
            flag =true;
            return flag;
        }
        else {
            while (ori!=0){
                digit = ori%10;
                reversed = (reversed*10)+digit;
                ori = ori/10;
            }
            if(reversed == x){
                flag = true;
                return flag;
            }
            else {
                return flag;
            }
        }
    }
}