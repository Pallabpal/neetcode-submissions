class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    void Solve(int [] nums, int ind, List<Integer> temp){
        if(ind == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //not pick
        Solve(nums, ind + 1, temp);
        //pick
         temp.add(nums[ind]);
         Solve(nums, ind +1, temp);
         temp.remove(temp.size() - 1);
        
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        Solve(nums, 0, new ArrayList<>());
        return ans;
    }
}
