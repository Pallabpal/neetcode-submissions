class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer>pos = new ArrayList<>();
        ArrayList<Integer>neg = new ArrayList<>();
        ArrayList<Integer>ans = new ArrayList<>();

        for(int i =0; i<nums.length; i++){
            if(nums[i]>0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }

        int i =0;
        int j = 0;
        while(i < pos.size() || j<neg.size()){
           if(i<pos.size())ans.add(pos.get(i++));
           if(j<neg.size()) ans.add(neg.get(j++));
        }

        int[] res = new int[nums.length];

        for(int k =0; k<nums.length; k++){
            res[k] = ans.get(k);
        }

        return res;
    }
}