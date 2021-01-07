package leetcode.p62;

class Solution {
    public int uniquePaths(int m, int n) {
        long res=1;
        for(int i=1,j=m;i<n;i++,j++){
            res=res*j/i;
        }
        return (int)res;
    }
}