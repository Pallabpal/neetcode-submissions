class KthLargest {
    
    Queue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
    int k;
    int [] nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for(int i =0; i<nums.length; i++){
            pq.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        
        
        pq.offer(val);
        while(pq.size() >k){
             pq.poll();
        }
        return pq.peek();
         
    }
}
