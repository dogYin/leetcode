package structClass.sort;

import structClass.util.PrintArray;

import java.util.Arrays;

public class QuickSort extends PrintArray {
    @Override
    public void doMethod(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
      String temp = "1";
      switch (temp){
          case "+":
          default:

      }
    }
    static void test(int arr[], int left , int right){
        if(left > right)return;
        int l = left;
        int r = right;
        int pod = arr[left];
        while (left < right){
            while (left < right && pod < arr[right]){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && pod > arr[left]){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pod;
        test(arr,l,left-1);
        test(arr,left +1,r);
    }

    private void quickSort(int[] arr,int left,int right) {
        if(left > right)return;
        int l = left;
        int r = right;
        int pod = arr[left];
        while (left < right){
            while (left < right && arr[right] > pod){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < pod){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pod;
        quickSort(arr,l,left-1);
        quickSort(arr,left +1,r);
    }

    void  quickSort1(int[] arr , int left,int right){
        if(left > right)return;
        int l = left;
        int r = right;
        int pod = arr[left];
        while (left < right){
            while (left < right && pod < arr[right]){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && pod > arr[left]){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pod;
        quickSort(arr,l,left-1);
        quickSort(arr,left+1,r);
    }


    void test1(int[] arr,int left, int right){
        if(left < right){
            int pod = arr[left];
            int l = left;
            int r = right;
            while (left < right){
                while (left < right && arr[right] > pod){
                    right--;
                }
                arr[left] = right;
                while (left < right && arr[left] < pod){
                    left++;
                }
                arr[right] =  arr[left];
            }
            arr[left] = pod;
            test1(arr,l,left);
            test1(arr,left + 1,r);
        }
    }

    private int partion(int[] arr, int left, int right) {
        return 0;
    }
}
