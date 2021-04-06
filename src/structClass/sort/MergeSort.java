package structClass.sort;

import structClass.util.PrintArray;

public class MergeSort extends PrintArray {
    @Override
    public void doMethod(int[] arr) {
        mergeSort(arr,0,arr.length-1,new int[arr.length]);
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,5,2,7,6};
        MergeSort sort = new MergeSort();
        sort.invoke(arr);
    }

  private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {

            int mid = (left + right) >> 1;
            //拆左边
            mergeSort(arr, left, mid, temp);
            //拆右边
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }


    private void merge(int[] arr,int left,int mid,int right,int[] temp){

        int lIndex = left;
        int rIndex = mid+1;
        int tIndex =0;

        //两个子串比较归并
        while (lIndex < mid && rIndex < right){
            if(arr[lIndex] > arr[rIndex]){
                temp[tIndex++] = arr[rIndex++];
            }else {
                temp[tIndex++] = arr[lIndex++];
            }
        }

        //左边多出来的
        while (lIndex <= mid){
            temp[tIndex++] = arr[lIndex++];
        }

        //右边多出来的
        while (rIndex <= right){
            temp[tIndex++] = arr[rIndex++];
        }
        //复制到原数组
        while (tIndex >0){
            arr[right--] = temp[--tIndex];
        }
    }



    void mergeSoert1(int[] arr,int left,int right,int[] temp){
        if(left > right)return;

        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr,mid + 1, right,temp);

        merge1(arr,left,mid,right,temp);
    }

    private void merge1(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l < mid && r < right){
            if(arr[l] > arr[r]){
                temp[t++] = arr[r++];
            }else {
                temp[t++] = arr[l++];
            }
        }
        while (l <= mid){
            temp[t++] = arr[l++];
        }

        while (r <= right){
            temp[t++] = arr[r++];
        }
        while (t > 0){
            arr[right--] = temp[--t];
        }
    }
}

