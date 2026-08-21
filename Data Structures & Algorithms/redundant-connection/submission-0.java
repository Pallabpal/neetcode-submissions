class Solution {
    int []par;
    int find(int i){
        
        if(par[i] == i) return i;
        
        return find(par[i]);
    }

    void union(int i, int j){
        int irep = find(i);

        int jrep = find(j);

        par[irep] = jrep;
    }
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;

        par = new int[n+1];

        for(int i=1; i<=n; i++){
            par[i]= i;
        }

        for(int[] edge: edges){
            if(find(edge[0]) == find(edge[1])){
                return new int[]{edge[0], edge[1]};
            }
            union(edge[0], edge[1]);
        }
        
        return new int[0];

    }
}
