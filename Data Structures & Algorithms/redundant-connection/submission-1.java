class Solution {

   int[] par;
    private int findParent(int i){
       if(i == par[i]){
          return i;
       }

      return findParent(par[i]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length + 1];

        for(int i =0; i<edges.length+1; i++){
            par[i] = i;
        } 

        for(int i =0; i<edges.length; i++){
           
           //find parent for both
           int parx = findParent(edges[i][0]);
           int pary = findParent(edges[i][1]);

           if(parx == pary){
               return new int[]{edges[i][0], edges[i][1]};
           }else{
             par[parx] = pary;
           }
        }

            return new int[]{-1, -1};

    }
}

