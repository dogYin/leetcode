package structClass.greedy.middle;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description:
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @Author: jiabin.wang
 * @Date: 2020/11/6 10:45
 */
public class ReconstructQueue_406 {


    private static int[][] reconstructQueue(int[][] people){
        if(null == people || people.length == 0)return null;
        Arrays.sort(people,(o1,o2)->o1[0] == o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] temp: people) {
            res.add(temp[1],temp);
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] res = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        System.out.println(reconstructQueue(res));
    }
}
