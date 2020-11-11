package structClass.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/10/30 15:47
 */
public class GenOrderIdUtil {

    public static Long test(String shardingValue){

        //获取分库关键字hashcode  为了取模结果分布均匀
        String strValue=String.valueOf(shardingValue);
        int id = Math.abs(strValue.hashCode());
        System.out.println("hash code："+ id);
        //和8192取模就是为了后续处理id落在哪个库范围（类似于redis槽节点分配）
        long sid =  id % 8192 ;
        System.out.println("分库编号:"+sid);
        //防止越界
        if(sid > 8191){
            sid = 8192 ;
        }
        long increment=0;
        //获取当前时间戳  秒级别
        long currentTime=System.currentTimeMillis()/1000;
        System.out.println("当前时间戳："+Long.toBinaryString(currentTime));
        //redis 发号器
        /*try {
            AtomicCommands ac = RedisFactory.getClusterAtomicCommands(ORDER_SERIAL);
            //时间+项目名称+业务名称
            String key = String.valueOf(currentTime) + "_" + projectName +"_"+busType;
            increment = ac.increment(1, key, INCREMENT);
            if (increment == 1) {
                ac.expire(1, key, UNIQUETIMEOUT, TimeUnit.SECONDS);
            }
        }catch (Exception e) {
            LOGGER.error("getSerialNoIncrease error " + 1, e);
        }*/
        //当前时间戳往前移动32位  我们知道long是64 位，首先前32位是时间戳，首先从时间上保证了有序性
        System.out.println("时间戳移动后："+ Long.toBinaryString(currentTime<<32));
        //并发情况下  同一秒有可能后面进来的shareNo小于前面的 在这里有序性不能被保证
        // shareno不同唯一性保证了，就算进来同一个shareNo但是redis发号器这里又保证了唯一性
        System.out.println("sid移动后:"+ Long.toBinaryString(sid<<16));
        System.out.println("时间戳和sid求或："+Long.toBinaryString((currentTime<<32)|(sid<<16)));
        return (Long)((currentTime<<32)|(sid<<16)|(increment));
    }

    public static void main(String[] args) {
        //1011111100110111100101001001111

        //101111110011011110010100100111100000000000000000000000000000000   移动后的时间戳
        //                                  11110100101010000000000000000   移动后的shareNo
        //101111110011011110010100100111100011110100101010000000000000000   二者求或
        //101111110011011110010100100111100011110100101010000000000000001   最后加上发号器
//        System.out.println(test("2019032466"));


        List<String> list = new ArrayList<>();
        list.add("LK02");
        list.add("LK04");
        list.add("LK01");
        list.add("LK03");
        list.add("LK05");
        Collections.sort(list);

        list.stream().forEach(System.out::println);


    }
}
