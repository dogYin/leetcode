package structClass.greedy.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 *
 * @Author: jiabin.wang
 * @Date: 2020/11/5 14:47
 */
public class EraseOverlapIntervals_435 {

    public static int eraseOverLapIntervals(int[][] intervals){
        if(intervals.length == 0 || intervals == null)return 0;
        int res = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] -o2[1] ;
            }
        });
        int low = intervals[0][0];
        int high = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int j = intervals[i].length-1;
            int tempLow = intervals[i][0];
            int tempHigh = intervals[i][j];
            if(tempLow >= low && tempLow < high){
                res++;
                continue;
            }
            if(tempLow<low){
                low = tempLow;
            }
            if(tempHigh>high){
                high = tempHigh;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //[]
        System.out.println(eraseOverLapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
    }
}
