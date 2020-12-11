package structClass.Thread;

import structClass.Thread.BlockingDeque;
/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/2 20:07
 */
@FunctionalInterface
public interface RejectPolicy<T> {

    void reject(BlockingDeque<T> deque,T task);
}
