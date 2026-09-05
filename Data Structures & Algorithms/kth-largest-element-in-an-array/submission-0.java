class Solution {
    public int findKthLargest(int[] nums, int k) {
    
       int n  = nums.length;
       PriorityQueue<Integer> pq = new PriorityQueue<>();

       int ct =0;
       for(int i =0; i<n ; i++){
          
          pq.offer(nums[i]);
          while(pq.size()>k){
            pq.poll();
          }
          
       }

       return pq.peek();

    }
}
