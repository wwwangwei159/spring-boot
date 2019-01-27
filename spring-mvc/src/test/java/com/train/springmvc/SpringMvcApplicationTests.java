package com.train.springmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMvcApplicationTests {

    @Test
    public void contextLoads() {
    }


    private final String url = "http://localhost:8080/mvc/user/query?userId=1";

    private static final int USER_NUMS = 200;

    private static CountDownLatch countDownLatch =  new CountDownLatch(USER_NUMS);

    public TestRestTemplate restTemplate  = new TestRestTemplate();

    @Test
    public void getUserId() {

        for (int i=0;i<USER_NUMS;i++){
            new Thread(new TicketRequest()).run();
            System.out.println("i==="+i);
            countDownLatch.countDown();
        }



    }

    public class TicketRequest implements Runnable{

        @Override
        public void run() {

            try{
                countDownLatch.await();
            }catch (Exception e){

            }
            String s = restTemplate.getForObject(url,String.class);
            System.out.println("sss========"+s);

        }
    }

}

