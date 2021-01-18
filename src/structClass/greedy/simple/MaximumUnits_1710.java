package structClass.greedy.simple;

import java.util.Arrays;

/**
 * @Description:
 * 卡车上最大单元数量
 * link:https://leetcode-cn.com/problems/maximum-units-on-a-truck/
 *
 * 思路：
 *      条件：
 *       [[number-i,maxNum-i]]
 *       number-i : 第i个箱子数量
 *       maxNum-i : 每个箱子装载的最大数量
 *
 *       思路：
 *       我们可以先装单个装载最多的箱子，数量不够弥补，数量够装载指定数量即可
 *
 * @Author: jiabin.wang
 * @Date: 2021/1/7 14:18
 */
public class MaximumUnits_1710 {


    public static int maximumUnits(int[][] boxTypes,int truckSize){
        //按照最大装载数量排序
        Arrays.sort(boxTypes,((o1, o2) ->  o2[1] == o1[1] ? o2[0] -o1[0] : o2[1] - o1[1]));
        int res = 0;
        for (int i = 0; i < boxTypes.length  ; i++) {
            int num = boxTypes[i][0];
            int maxUnit = boxTypes[i][1];
            int temp = truckSize - num;
            if(temp > 0){
                res += num *maxUnit;
                truckSize = temp;
            }else {
                res+=truckSize * maxUnit;
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
       // []  24
        // [5,5] [5,5] [2,5]
        System.out.println(maximumUnits(new int[][]{ {4,2},{5,5},{4,1},{1,4},{2,5},{1,3},{5,3},{1,5},{5,5},{1,1}},24));
    }
}
