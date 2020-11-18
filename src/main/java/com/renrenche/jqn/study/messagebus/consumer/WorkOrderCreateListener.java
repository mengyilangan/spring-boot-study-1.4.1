//package com.renrenche.jqn.study.messagebus.consumer;
//
//
//import com.renrenche.messagebus.client.annotation.Consumer;
//import com.renrenche.messagebus.client.enums.ConsumeFailedPolicy;
//import com.renrenche.messagebus.client.listener.AbstractMessageListener;
//import com.renrenche.messagebus.common.message.Message;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 监听建单完成的消息
// *
// * @author jiangqiaonan
// */
//@Slf4j
//@Consumer(name = "inspector_task_allocate_car_consumer", failedPolicy = ConsumeFailedPolicy.RETRY)
//public class WorkOrderCreateListener extends AbstractMessageListener {
//
//    @Override
//    public void onMessage(Message message) throws Exception {
//        try {
//            String body = message.getBody();
//            log.debug("接受到的消息是;rrcMessage=[{}],tag=[{}]", body, message.getHeader().getTag());
//            Thread.sleep(1000 * 30);
//        } catch (Exception e) {
//            log.warn("消息消费异常;message={},e=[{}],", message, e.getMessage());
//            throw e;
//        }
//    }
//}
