package structClass.sort;

import structClass.util.PrintArray;

public class BubbleSort extends PrintArray{

    public static void main(String[] args){

        int[] arr = {1,4,3,5,2,7,6};
        BubbleSort sort = new BubbleSort();
        sort.invoke(arr);
    }


    public  void bubbleSort(int[] arr){
        for (int i = 0;i < arr.length - 1; i++ )
        {
            for(int j = 0; j < arr.length - 1 -i;j++)
            {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public  void bubbleSortOptimize(int[] arr){
        boolean flag = false;
        for (int i = 0;i < arr.length - 1; i++ )
        {
            for(int j = 0; j < arr.length - 1 -i;j++)
            {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag)break;
        }
    }

    @Override
    public void doMethod(int[] arr) {
        bubbleSort(arr);
    }
}
