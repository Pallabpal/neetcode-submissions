class Solution {

    ArrayList<ArrayList<int[]>>adj  = new ArrayList<>();
    private void adjacency(int src, int dest, int cost){
      
      adj.get(src).add(new int[]{dest, cost});

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    int min = Integer.MAX_VALUE;

      for(int i =0; i<n; i++){
        adj.add(new ArrayList<>());
      }
      
      for(int[] flight : flights){
          adjacency(flight[0], flight[1], flight[2]);
      }

      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

      int maxStop = k+1;
      int[] dest = new int[n];

      Arrays.fill(dest, Integer.MAX_VALUE);
      dest[src] = 0;
      pq.offer(new int[]{0, src, 0});
      while(!pq.isEmpty()){

        int[] node = pq.poll();

        int cost = node[2];
        int reached = node[1];
        int stops = node[0];

        if(reached == dst){
            min = Math.min(min, cost);
            continue;
        }

        if(maxStop <= stops) continue;
        
      

        for(int[]neigh:adj.get(reached)){

            int nextNode = neigh[0];
            int edgeCost = neigh[1];
            
            if(dest[nextNode] > cost + edgeCost){
                dest[nextNode] = cost + edgeCost;
                pq.offer(new int[]{stops + 1, nextNode, dest[nextNode]});
            }
        }
      }
     
        return min == Integer.MAX_VALUE ? -1 : min; 
    }
}
