package structClass.greedy.simple;

/**
 * @Description:
 * link:https://leetcode-cn.com/problems/lemonade-change/
 * @Author: jiabin.wang
 * @Date: 2021/1/6 11:21
 */
public class LemonadeChange_860 {

    public static boolean lemonadeChange(int[] bills){
        if(null == bills || bills.length==0)return true;
        int five = 0;
        int ten = 0;
        int twety = 0;
        for (int i = 0;i< bills.length;i++){
           int temp = bills[i];
           if(temp == 5){five++;}
           else if(temp == 10) {
               if(five <=0)return false;
               ten++;
               five--;
           }else {
               if(ten<=0 && five < 3)return false;
               if(ten >0 && five < 1)return false;
               if(ten > 0){
                   ten--;
                   five--;
               }else {
                   five-=3;
               }
           }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,10,10,20}));
    }
}
