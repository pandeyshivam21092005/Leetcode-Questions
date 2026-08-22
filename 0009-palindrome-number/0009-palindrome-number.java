class Solution {
    public boolean isPalindrome(int x) {
        int original=x;
        int reverse=0;
        while(x>0){
            int lastdigit=x%10;
            x=x/10;
            reverse=(reverse*10)+lastdigit;
        }
        if(reverse==original) return true;
        else return false;
    }
}