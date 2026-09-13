class Solution {
    public int minimizeMax(int[] nums, int p) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n-1] - nums[0];
        int ans = right;
        while(left <= right){
            int mid = (left + right) /2;

            if(isValid(nums, mid, p)){
                right = mid -1;
                ans = mid;
            }
            else{
                left = mid +1;
            }
        }

        return ans;
    }


    boolean isValid(int[] nums, int thre, int p){

        int ct =0, i =0;

        while(i<nums.length -1){
           if(Math.abs(nums[i] - nums[i+1])<=thre){
            ct ++;
            i = i+2;
           }
           else{
            i ++;
           }
        }

        if(ct >= p) return true;
        return false;
    }
}