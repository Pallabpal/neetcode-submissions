class Solution {
     int[] visited;
     private boolean dfs(ArrayList<ArrayList<Integer>> adj , int src){
        visited[src] = 1;

        for(int u: adj.get(src)){
            if(visited[u] == 0){
                dfs(adj, u);
            }
            
        }

        return false;
    }
    private void build(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        visited = new int[n];
        Arrays.fill(visited, 0);
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0; i<edges.length; i++){
            build(adj, edges[i][0], edges[i][1]);
        }
        int ans = 0;
        
        for(int i =0; i<n; i++){
           if(visited[i] == 0){
             dfs(adj, i);
             ans++;
           }
        }
       return ans;
    }
}
