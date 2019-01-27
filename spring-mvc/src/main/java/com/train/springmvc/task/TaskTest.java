package com.train.springmvc.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@Component
public class TaskTest {

    @Async
    public Future<Map> testAsync1(){
        System.out.println("begin testAsync1");
        long begin = System.currentTimeMillis();
        Map a = new HashMap();
        a.put("a","aaa");
        a.put("b","bbb");
        a.put("c","ccc");

        Future<Map> future = new AsyncResult<Map>(a);
        try {
            Thread.sleep(10000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("end testAsync1  "+(end-begin)+"毫秒");
        return future;

    }

    @Async
    public Future<String> testAsync2(int i) {
        System.out.println("begin testAsync2");

        Future<String> future;
        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(100 * 1);
            future = new AsyncResult<String>("success:" + i);
        } catch (InterruptedException e) {
            future = new AsyncResult<String>("error");
        }

        long end = System.currentTimeMillis();
        System.out.println("end testAsync2   "+(end-begin)+"毫秒");
        return future;

    }

}
