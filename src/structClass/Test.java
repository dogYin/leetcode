package structClass;


import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import structClass.Thread.Singleton;
import structClass.util.TreeNode;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/11/16 11:10
 */
public class Test{

    public static void main(String[] args) {


    }

    public int clumsy(int N) {
        switch(N){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 7;
            default:
                return cal(N);
        }
    }

    int cal(int n){
        int x = n % 4;
        int m = n-x;
        int res = 0;
        while(m > 0){
            res+= Math.ceil(n * (n-1)/(n-2))+(n-3);
            m /=4;
        }
        switch(x){
            case 3:
                res+= 6;
                break;
            case 2:
                res+=2;
                break;
            case 1:
                res++;
                break;
            default:
                break;
        }
        return res;

    }


}

