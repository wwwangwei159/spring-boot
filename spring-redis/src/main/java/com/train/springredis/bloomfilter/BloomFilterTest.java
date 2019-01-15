package com.train.springredis.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BloomFilterTest {

    private BloomFilter<String> bf = null;

    /**
     * 这个方法得用多线程编程，并且初始化.
     */
    @PostConstruct
    public void init(){

        //get all data from service.
        List<String> expressIds = new ArrayList<>();
        //默认初始化都为2倍
        bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),expressIds.size()*2);
        for (String code:expressIds){
            bf.put(code);
        }
    }


    public boolean getBloomFlag(String express){
        //判断是否存在数据
        if(bf.mightContain(express)){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {

        String expressNo = "excess";

        BloomFilterTest test = new BloomFilterTest();
        test.init();
        //if false,will return
        if(!test.getBloomFlag(expressNo)){
            log.debug(test.getBloomFlag(expressNo)+"");
            log.debug("invalid express");
            //return null;
        }

        //if true will goto redis to check data.
        Jedis jedis = new Jedis("127.0.0.1",6389);
        if(jedis.get(expressNo)!=null){
            log.debug("get value from redis server key "+expressNo+":"+jedis.get(expressNo));
        }


    }

}
