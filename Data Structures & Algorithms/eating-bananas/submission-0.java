class Solution {

    public boolean possible(int[] piles, int k, int h){
        
        int ct = 0;
        for(int i =0; i<piles.length; i++){
          if(piles[i] < k) ct ++;
          else{
            ct += piles[i] % k == 0 ? piles[i]/k : (piles[i] /k) + 1;
          }

        }
        System.out.println(k + " " + ct);
         return ct<=h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int maxi =-1;
        int n = piles.length;

        for(int i = 0; i<n; i++){
            maxi = Math.max(maxi, piles[i]);
        }

        int right = maxi;
        int left = 1;
        int ans = -1;
        while(left <= right){

            int mid = (left + right) /2;

            if(possible(piles, mid, h)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid +1;
            }
        }

        return ans;
    }
}
