class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int left = 0;
        int right = intervals.length - 1;
        int target = newInterval[0];

        while(left <=right){
            int mid = (left + right) /2;

            if(intervals[mid][0] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        List<int[]> result = new ArrayList<>();
        for(int i =0; i<left ; i++){
            result.add(intervals[i]);
        }

        result.add(newInterval);

        for(int i =left; i<intervals.length; i++){
             result.add(intervals[i]);
        }

        ArrayList<int[]> ans = new ArrayList<>();

        int currentStart = result.get(0)[0];

        int currentEnd = result.get(0)[1];

        for(int i =1 ; i<result.size(); i++){

            if(currentEnd < result.get(i)[0]){
                ans.add(new int[]{currentStart, currentEnd});
                currentEnd   = result.get(i)[1]; 
                currentStart = result.get(i)[0];
            }
            else{
                currentEnd = Math.max(currentEnd, result.get(i)[1]);
            }
        }
        ans.add(new int[]{currentStart, currentEnd});

       return ans.toArray(new int[0][]);
        
    }
}
