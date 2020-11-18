package structClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/11/16 11:10
 */
public class Test {

    private static int[][] test(int[][] people){
        if(null == people || people.length == 0 || people[0].length == 0)return people;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] temp: people) {
            res.add(temp[1],temp);
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {

    }
}
