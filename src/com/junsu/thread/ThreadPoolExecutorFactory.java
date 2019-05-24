package com.junsu.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class ThreadPoolExecutorFactory {

    private static final int CORE_POOL_SIZE=5;
    private static final int MAX_POOL_SIZE=5;
    private static final int QUEUE_SIZE=1;
    private static final int KEEP_ALIVE_TIME=60;

    public static ThreadPoolExecutor createThreadPoolPolicy(ThreadPoolPolicyType policyType){
        final ThreadPoolExecutor tempThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,KEEP_ALIVE_TIME,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(QUEUE_SIZE));
        switch (policyType){
            case ABORT_POLICY:
                tempThreadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
                break;
            case CALLERRUNS_POLICY:
                tempThreadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
                break;
            case DISCARD_POLICY:
                tempThreadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
                break;
            case DISCARDOLDEST_POLICY:
                tempThreadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
                break;
            default:
                throw new RuntimeException("ThreadPoolExecutor에 없는 Policy 이름입니다.");
        }
        return tempThreadPoolExecutor;
    }

}
