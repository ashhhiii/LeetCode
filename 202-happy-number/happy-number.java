class Solution {
    public boolean isHappy(int n) {
           int slow = n;
    int fast = n;

    do{
        slow = findSqr(slow);
        fast = findSqr(findSqr(fast));

    }while(slow != fast);

    if(slow == 1){
        return true;
    }
    return false;

}
private int findSqr (int number){
    int ans=0;
    while(number>0){
        int rem = number %10;
        ans += rem *rem;
        number/=10;
    }
    return ans;
}

        
    }
