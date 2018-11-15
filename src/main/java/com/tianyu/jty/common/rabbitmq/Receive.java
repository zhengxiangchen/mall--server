package com.tianyu.jty.common.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Receive implements MessageListener {

    public static ArrayList<String> newOrderList = new ArrayList<String>();

    @Override
    public void onMessage(Message message) {
        System.out.println("您有新订单了");
        newOrderList.add(message.getBody().toString());
    }


    public ArrayList<String> getNewOrderList(){
        ArrayList<String> retList = newOrderList;
        return retList;
    }

    public void clearList(){
        newOrderList.clear();
    }
}
