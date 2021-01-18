package structClass.greedy.simple;

/**
 * @Description:
 * link:https://leetcode-cn.com/problems/water-bottles/
 * 换酒问题
 * 指定数量的酒瓶能换一瓶（好坑）
 *
 * @Author: jiabin.wang
 * @Date: 2021/1/7 15:00
 */
public class NumWaterBottles_1518 {

    public static int numWaterBottles(int numBottles, int numExchange) {
        //处理边界条件
        if(numExchange > numBottles)return numBottles;
        //基础量
        int res = numBottles;
        //空瓶数量
        int nullBottles = numBottles ;
        while (numExchange <= nullBottles){
            //换了几瓶
            int exchangeBottles = nullBottles / numExchange;
            res += exchangeBottles;
            //更新空瓶数量
            nullBottles = (exchangeBottles + nullBottles % numExchange);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9,3));
        System.out.println(numWaterBottles(15,4));
        System.out.println(numWaterBottles(5,5));
        System.out.println(numWaterBottles(2,3));
    }
}
