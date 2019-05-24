package com.junsu.thread;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolPolicyTest {

    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.createThreadPoolPolicy(ThreadPoolPolicyType.DISCARDOLDEST_POLICY);

        try{
            for (int i=0;i<10;i++){
                Runnable run = () -> {
                    ThreadPoolExecutor threadPool = threadPoolExecutor;
                    System.out.print("Thread Count: "+threadPool.getPoolSize());
                    System.out.println(", Current Count: "+Thread.currentThread().getName());
                };
                threadPoolExecutor.execute(run);
            }
        }catch(RejectedExecutionException rejected){
            rejected.printStackTrace();
        }

    }
}
