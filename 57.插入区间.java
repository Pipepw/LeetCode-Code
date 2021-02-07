class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        int loc = findLoc(intervals, newInterval); // 当前位置与小于等于的位置重叠
        int maxR = newInterval[1], Lef = intervals[loc][0];
        List<int[]> tempRes = new ArrayList<>();
        if (intervals[loc][1] >= newInterval[1]) { // 被吞并了
            return intervals;
        }
        for (int i = 0; i < loc; i++) {
            tempRes.add(intervals[i]);
        }
        if (intervals[loc][1] < newInterval[0]) { // 整体在插入的前面
            tempRes.add(intervals[loc]);
            Lef = newInterval[0];
        }
        int point = loc + 1;
        while (point < intervals.length) { // 剩下的只需要与end比较
            if (intervals[point][1] > maxR) {
                if (intervals[point][0] <= maxR) { // 这个的结束作为最远
                    maxR = intervals[point][1];
                    point++;
                }
                break; // 前面的都可以直接合并了
            }
            point++;
        }
        tempRes.add(new int[] { Lef, maxR });
        for (int i = point; i < intervals.length; i++) {
            tempRes.add(intervals[point]);
        }
        return tempRes.toArray(new int[tempRes.size()][]);
    }

    public int findLoc(int[][] intervals, int[] newInterval) {
        int loc, start = -1, mid = intervals.length >> 1, end = intervals.length;
        while (true) {
            if (start + 2 == end) {
                loc = start + 1;
                break;
            }
            // System.out.println("mid = " + mid + ", start = " + start + ", end = " + end);
            if (intervals[mid][0] <= newInterval[0]) {
                if (mid == intervals.length - 1 || intervals[mid + 1][0] > newInterval[0]) {
                    loc = mid; // 固定位置为小的那个
                    break;
                } else {
                    start = mid;
                    mid = (mid + end - 1) >> 1;
                }
            } else if (intervals[mid][0] > newInterval[0]) {
                if (intervals[mid - 1][0] <= newInterval[0]) {
                    loc = mid - 1;
                    break;
                } else {
                    end = mid;
                    mid = (mid + start + 1) >> 1;
                }
            }
        }
        return loc;
    }
}
