package structClass.offer;

/**
 * @Description:
 *
 *
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。



示例:

现有矩阵 matrix 如下：

[
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。


 * @Author: jiabin.wang
 * @Date: 2020/12/7 17:39
 */
public class FindNumberIn2DArray_04 {

    private static boolean findNumberIn2DArray(int[][] matrix,int target){
        if(matrix == null || matrix.length == 0)return false;
        int  m = matrix.length-1;
        int n = matrix[0].length-1;
        int j = 0;
        while ( m >= 0 &&  j<=n){
            if(matrix[m][j] > target ){
                m--;
            }else if(matrix[m][j] < target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
