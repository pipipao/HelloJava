class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int h=heights[i];
            int left=i;
            int right=i;
            while(left>0&&heights[left-1]>=h){
                left--;
            }
            while(right<heights.length-1&&heights[right+1]>=h){
                right++;
            }
            int area=(right-left+1)*heights[i];
            if(area>maxArea){
                maxArea=area;
            }
        }
        return maxArea;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack=new Deque<>();
        

    }
}