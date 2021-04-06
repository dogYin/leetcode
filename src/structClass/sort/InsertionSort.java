package structClass.sort;

import structClass.util.PrintArray;

public class InsertionSort extends PrintArray {

    public static void main(String[] args) {
        int[] arr = {1,4,3,5,2,7,6};
        InsertionSort sort = new InsertionSort();
        sort.invoke(arr);
    }

    @Override
    public void doMethod(int[] arr) {
        insertionSort(arr);
    }

    public void insertionSort(int[] arr){
        for (int i = 0; i < arr.length-1 ; i++)
        {
            for (int j = i + 1 ;j >0 ;j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
