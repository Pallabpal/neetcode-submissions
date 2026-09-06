class Solution {
    public int leastInterval(char[] tasks, int n) {

     int[] count = new int[26];
     
     for(char task :tasks){
          count[task- 'A'] ++;
     }
     
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
     for(int i =0; i<26; i++){
        if(count[i] >0){
        pq.offer(count[i]);
        }
     }

     Queue<int[]>q = new LinkedList<>();

     int time = 0;

     while(!pq.isEmpty() || !q.isEmpty()){
        time ++;

        if(pq.isEmpty()){
            time = q.peek()[1]; 
        }else{
            int ct = pq.poll();
            ct --;
            if(ct >0){
            q.offer(new int[]{ct, time+n});
            }

        }

        if(!q.isEmpty() && q.peek()[1] == time){
            pq.offer(q.poll()[0]);
        }
     }
     
      return time;
    }
}
