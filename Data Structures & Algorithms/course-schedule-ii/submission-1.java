class Solution {
    private int[] visited;
    private int[] dfsVisited;
    boolean isCycle = false;
    Stack<Integer> st = new Stack<>();
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int src){
         visited[src] = 1;
         dfsVisited[src] = 1;
         for(int u: adj.get(src)){
            if(visited[u] == 0){
               if(dfs(adj, u)) return true;
            }
            else{
                if(dfsVisited[u] == 1){
                    return true;
                }
            }
         }
         dfsVisited[src] = 0;
         return false;
    }

    private void topoSort(ArrayList<ArrayList<Integer>>adj, int src){
          visited[src] = 1;
         
          for(int u: adj.get(src)){
            if(visited[u] == 0)
               topoSort(adj, u);
          }
           st.push(src);
    }
    private void build(ArrayList<ArrayList<Integer>>adj, int u, int v){
        adj.get(u).add(v);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int n = numCourses;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0; i<n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<prerequisites.length; i++){
            build(adj, prerequisites[i][1], prerequisites[i][0]);
        }

        

        visited = new int[n];
        dfsVisited = new int[n];
        Arrays.fill(visited, 0);
        Arrays.fill(visited, 0);

        for(int i=0 ; i<n; i++){
            if(visited[i] == 0){
                if(dfs(adj, i)){
                    isCycle = true;
                    break;
                }
            }
        }

        if(isCycle) return new int[0];


       visited = new int[n];
       Arrays.fill(visited, 0);

       for(int i=0; i<n; i++){
          if(visited[i] == 0){
           topoSort(adj, i);
          }
       }

       int[] res = new int[n];
       int i =0;
       while(!st.empty()){
           res[i++] = st.pop();
       }

       return res;



    }
}
