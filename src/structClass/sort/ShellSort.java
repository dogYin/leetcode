package structClass.sort;

import structClass.util.PrintArray;

public class ShellSort extends PrintArray {

    public static void main(String[] args) {
        int[] arr = {1,4,3,5,2,7,6};
        ShellSort shellSort = new ShellSort();
        shellSort.invoke(arr);
    }
    @Override
    public void doMethod(int[] arr) {
        shellSort(arr);
    }

    public void shellSort(int[] arr){
      for (int gap = arr.length /2 ; gap >= 1; gap /=2)
      {
          for (int i = gap ;i < arr.length ;i++)
          {
              for (int j = i -gap; j >=0 ; j-=gap) {
                  if(arr[j] > arr[j+ gap])
                  {
                      int temp = arr[j];
                      arr[j] = arr[j+ gap];
                      arr[j+gap] = temp;
                  }
              }
          }
      }
    }

}
