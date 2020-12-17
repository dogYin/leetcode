package structClass.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/16 10:19
 */
public class WordPattern_1216 {


    public static  boolean wordPattern(String parttern,String s){
        String[] partternSplit = parttern.split("");
        String[] sSpilt = s.split(" ");
        if(partternSplit.length != sSpilt.length)return false;
        Map<String,Integer> partternMap = new HashMap<>(partternSplit.length);
        Map<String,Integer> sMap = new HashMap<>(partternSplit.length);
        for (int i = 0; i < partternSplit.length; i++) {
            if((partternMap.containsKey(partternSplit[i]) && !sMap.containsKey(sSpilt[i]) )
                    || (sMap.containsKey(sSpilt[i]) && ! partternMap.containsKey(partternSplit[i]))){
                return false;
            }
            sMap.put(sSpilt[i],i);
//            partternMap.put(partternSplit[i],String.valueOf(i).charAt(0));
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("aba","dog cat cat   "));
    }
}
