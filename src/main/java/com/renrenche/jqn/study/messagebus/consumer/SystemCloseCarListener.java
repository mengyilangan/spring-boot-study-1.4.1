//package com.renrenche.jqn.study.messagebus.consumer;
//
//import com.alibaba.fastjson.JSON;
//import com.renrenche.messagebus.client.annotation.Consumer;
//import com.renrenche.messagebus.client.enums.ConsumeFailedPolicy;
//import com.renrenche.messagebus.client.listener.AbstractMessageListener;
//import com.renrenche.messagebus.common.message.Message;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * 监听车辆状态变更的消息
// *
// * @author jiangqiaonan
// */
//@Slf4j
//@Consumer(name = "car_operate_notice_consumer", failedPolicy = ConsumeFailedPolicy.RETRY)
//public class SystemCloseCarListener extends AbstractMessageListener {
//
//    private static final String CLOSE_CAR_TAG = "car_close";
//
//
//    @Override
//    public void onMessage(Message message) throws Exception {
//        try {
//            String body = message.getBody();
//            log.info("接受到的消息是;rrcMessage=[{}],tag=[{}]", body, message.getHeader().getTag());
//            if (CLOSE_CAR_TAG.equals(message.getHeader().getTag())) {
//                log.warn("关单操作;body={}",body);
//            }
//        } catch (Exception e) {
//            log.warn("消息消费异常;message={},e=[{}],", message, e.getMessage());
//            throw e;
//        }
//    }
//}
