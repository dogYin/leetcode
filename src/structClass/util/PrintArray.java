package structClass.util;

import java.util.Arrays;

public abstract class PrintArray {

    public void invoke(int[] arr){
        long startTime = System.currentTimeMillis();
        doMethod(arr);
        System.out.println("执行总耗时："+ (System.currentTimeMillis() - startTime));
        Arrays.stream(arr).forEach(System.out::print);
    }

    public abstract  void doMethod(int[] arr);

}
