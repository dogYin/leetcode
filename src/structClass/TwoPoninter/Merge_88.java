package structClass.TwoPoninter;

/**
 * @Description:
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *  
 *
 * 提示：
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 * @Author: jiabin.wang
 * @Date: 2020/10/14 14:27
 */
public class Merge_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mL = m - 1;
        int nL = n - 1;
        int k = m + n - 1;
        while (mL >=0 || nL >= 0){
            if(mL<0){
                nums1[k--] = nums2[nL--];
            }else if(nL<0){
                nums1[k--] = nums1[mL--];
            }else if(nums1[mL]> nums2[nL]){
                nums1[k--] = nums1[mL--];
            }else {
                nums1[k--] = nums2[nL--];
            }
        }
    }

}
