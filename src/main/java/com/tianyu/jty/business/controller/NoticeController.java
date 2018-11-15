package com.tianyu.jty.business.controller;

import com.tianyu.jty.common.rabbitmq.Receive;
import com.tianyu.jty.common.web.BaseController;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("business/notice")
public class NoticeController extends BaseController {

    @Autowired
    private Receive receive;



    @RequestMapping("/getNotice")
    public int getNotice(){
        int number = 0;
        ArrayList<String> noticeList = receive.getNewOrderList();
        if(noticeList.size() <= 0){
        }else{
            System.out.println("有订单通知了,有" + noticeList.size() + "条");
            number = noticeList.size();
            receive.clearList();
        }
        return number;
    }

}
