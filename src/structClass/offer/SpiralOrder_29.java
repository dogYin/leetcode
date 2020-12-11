package structClass.offer;

/**
 * @Description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * @Author: jiabin.wang
 * @Date: 2020/12/8 9:23
 */
public class SpiralOrder_29 {

    private static int[] spiralOrder(int[][] matrix){
        if(matrix == null || matrix.length == 0)return new int[0];
        //上下左右
       int l =0,r = matrix[0].length-1,u=0,d=matrix.length-1,x =0;
       //结果集
       int[] res = new int[(r+1) * (d+1)];
       while(true){
           //左 l -> 右 r
           for (int i = l; i <= r; i++) res[x++] = matrix[u][i];
           if(++u > d)break;
           //上 u -> 下 d
           for (int i = u; i <= d; i++) res[x++] = matrix[i][r];
           if(l >--r)break;
           //右 r -> 左 l
           for (int i = r; i >= l; i--) res[x++] = matrix[d][i];
           if(--d < u) break;
           //下 d -> 上 u
           for (int i = d; i <= u; i++) res[x++]  = matrix[i][l];
           if(++l > r)break;
       }
       return res;
    }

    public static void main(String[] args) {

    }
}
