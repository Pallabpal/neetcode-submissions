class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> aq = new ArrayDeque<>();

        int res[] = new int[n-k+1];
        for(int i=0; i<k; i++){

           while(!aq.isEmpty() && nums[aq.peekLast()] <= nums[i]){
            aq.removeLast();
           }
           aq.addLast(i);
           
        }
        int resInd = 0;        
        res[resInd++] = nums[aq.peekFirst()];
        int r = k;
        int l = 1;

        while(r<n){

            if(aq.peekFirst() < l){
                aq.removeFirst();
            }
            while(!aq.isEmpty() && nums[aq.peekLast()] <= nums[r]){
            aq.removeLast();
           }
           aq.addLast(r);
           res[resInd++] = nums[aq.peekFirst()];
           l++;
           r++;
        } 

        return res;
    }
}
