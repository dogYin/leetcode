package structClass.greedy.middle;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description:
 * link:https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/
 * 吃苹果
 *
 * 假设我们可以一直吃下去，看到时候有没有苹果供我们吃哪天断了说明吃不到了，返回断掉的天数即可
 *
 * @Author: jiabin.wang
 * @Date: 2021/1/7 16:18
 */
public class EatenApples_1705 {

    public static int eatenApples(int[] apples,int[] days){
        int res =0;
        for (int i =0 ;i< apples.length;i++){
            if(apples[i]==0 && days[i] == 0)continue;
            int temp = Math.min(days[i],apples[i]);
            int end = i + temp;
            if(end > res && i <= res){
                res = end;
            }else if(i > res) {
                res += temp;
            }
            System.out.println("第"+i + "->"+end+"  temp:"+ temp+"    res:"+res);
        }
        return res;
    }

    public static int eatenApples1(int[] apples, int[] days) {
        //<到期时间-对应的苹果数目>
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(cmp);
        int n=days.length;
        int res=0;
        int date=1;//日期
        for(int i=0;i<n||!priorityQueue.isEmpty();i++){
            /**树上还能产出苹果 或者 还有没过期的苹果可以吃**/
            if(i<n&&apples[i]!=0){//当天产出了苹果，加进去
                priorityQueue.add(new int[]{days[i]+i,apples[i]});
            }

            while (!priorityQueue.isEmpty()){//移除已经过期的苹果
                //可能有多个元素，因为相同的过期时间的苹果没有整合在一起，这不影响结果
                int [] temp=priorityQueue.peek();
                if(date>temp[0]){
                    priorityQueue.poll();
                }else{
                    break;
                }
            }
            if(!priorityQueue.isEmpty()) {//还有苹果可吃
                int[] temp = priorityQueue.poll();//一次循环是一天，一天只吃一个苹果
                /******弹出的队首temp肯定是符合期限要求而且数目大于0的****/
                res++;
                temp[1]--;
                if (temp[1] > 0) priorityQueue.add(new int[]{temp[0], temp[1]});
            }
            date++;
        }
        return res;
    }
    static Comparator<int[]> cmp =(o1,o2)-> o1[0]-o2[0];


    public static void main(String[] args) {
        //
        //[9,24,5,12,15,21,13,12,28,0,21,6,0,26,20,0,21,21,7,0,19,25,0,30,32,32,0,0,0,22,0,11,2,27,16,0,15,12,14,33,10,11,0,13,11,0,27,0,0,14,20,11,0,22,10,1,22,6,0,13,31,33,30,27,2,30,18]
        //[3,48,2,21,20,13,25,9,20,0,34,6,0,33,38,0,42,24,9,0,20,38,0,30,52,22,0,0,0,27,0,22,2,53,8,0,10,18,1,62,20,15,0,9,13,0,28,0,0,24,2,2,0,9,3,2,1,2,0,15,46,58,37,12,1,28,29]

        int[] apples = new int[]{2,2};
        int[] days = new int[]{3,4};
        System.out.println(eatenApples(apples,days));
    }

}
