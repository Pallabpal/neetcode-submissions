class Solution {

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean []visited, boolean []dfsVisited){
        dfsVisited[src] = true;
        visited[src] = true;

        for(int m : adj.get(src)){

            if(!visited[m]){
              if(dfs(adj, m, visited, dfsVisited)) return true;
            }else{
                if(dfsVisited[m]) return true;
            }
        }
        dfsVisited[src] = false;
        return false;
    }

    public void buildAdj(int m , int n, ArrayList<ArrayList<Integer>> adj){
        adj.get(m).add(n);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean []visited = new boolean[numCourses];
        boolean []dfsVisited = new boolean[numCourses];

        Arrays.fill(visited, false);
        Arrays.fill(dfsVisited, false);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
                for (int i =0; i<prerequisites.length; i++){
            buildAdj(prerequisites[i][1], prerequisites[i][0], adj);
        }

        for(int i =0; i< numCourses ; i++){
            if(!visited[i]){
              if(dfs(adj, i, visited, dfsVisited)) return false;
            }
        }

        return true;

        
    }
}
