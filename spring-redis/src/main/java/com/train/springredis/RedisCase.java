package com.train.springredis;

import redis.clients.jedis.Jedis;

public class RedisCase {

    public static void main(String args[]){



        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("abc","dccd");

        /*Pipeline pipeline = jedis.pipelined();
        pipeline.set("abc","333");
        jedis.flushDB();*/

        System.out.println(jedis.get("abc"));

    }

}
