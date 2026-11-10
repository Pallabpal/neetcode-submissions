class Solution {

    int par[];
    int sz[];
    int findPar(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = findPar(par[x]);
    }
    void union(int x, int y){

        int parx = findPar(x);
        int pary = findPar(y);
        int szx = sz[x];
        int szy = sz[y];

        if(parx == pary) return;
        
        if(szx >szy){
           par[pary] = parx;
        }
        else{
            par[parx] = pary;
        }
       
        return ;
    }
    public int[] findRedundantConnection(int[][] edges) {
     
     int n = edges.length;
     par = new int[n+1];
     sz = new int[n+1];

     for(int i =1; i<=n; i++){
        par[i] = i;
        sz[i] = 1;
     }
    

    for(int[]edge : edges){
        int x = edge[0];
        int y = edge[1];

        if(findPar(x) == findPar(y)){
            return new int[]{edge[0], edge[1]};
        }
        else{
            union(x,y);
        }
    }

    return new int[]{-1, -1};
        
    }
}
