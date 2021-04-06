package structClass.sort;

import structClass.util.PrintArray;

public class SelectSort extends PrintArray {

    public static void main(String[] args)
    {
        int[] arr = {1,4,3,5,2,7,6};
        SelectSort selectSort = new SelectSort();
        selectSort.invoke(arr);

    }

    public void selectSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j] < arr[minIndex])
                minIndex = j;
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }
    }

    @Override
    public void doMethod(int[] arr)
    {
        selectSort(arr);
    }
}
