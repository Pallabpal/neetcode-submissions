class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);

        for(int i=0; i<n ; i++){
            pq.offer(stones[i]);
        }
        System.out.println(pq.size());

        while(pq.size() >1){
            int a = pq.poll();
            int b = pq.poll();
            System.out.println(a + " " + b);
            if(a==b) continue;

            
                pq.offer(Math.abs(a-b));
            

        }

        if(pq.size() > 0) return pq.peek();
        return 0;
    }
}
