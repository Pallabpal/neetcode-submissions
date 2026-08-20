class Solution {

    private int[] visited;
    private boolean dfs(ArrayList<ArrayList<Integer>> adj , int src, int parent){
        visited[src] = 1;

        for(int u: adj.get(src)){
            if(visited[u] == 0){
                if(dfs(adj, u, src)) return true;
            }
            else{
                if(u!= parent){
                    return true;
                }
            }
        }

        return false;
    }
    private void build(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public boolean validTree(int n, int[][] edges) {

         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

         for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
         }

         for(int i=0; i<edges.length; i++){
            build(adj, edges[i][0], edges[i][1]);
         }

         visited = new int[n];
         Arrays.fill(visited, 0);

        if(dfs(adj, 0, -1)) return false;

        for(int i =0; i<n; i++){
            if(visited[i] == 0) return false;
        }


        return true;

    }
}
