/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

         if (intervals == null || intervals.size() <= 1) {
             return true;
         }
         
         intervals.sort(Comparator.comparingInt(a->a.start));
         
         int end = intervals.get(0).end;
         for(int i =1; i<intervals.size(); i++){
            int currStart = intervals.get(i).start;

            if(end > currStart){
                return false;
            }
            end = intervals.get(i).end;
         }

         return true;
    }
}
