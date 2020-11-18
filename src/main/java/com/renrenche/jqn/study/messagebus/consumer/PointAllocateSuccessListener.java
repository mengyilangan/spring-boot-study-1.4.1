//package com.renrenche.jqn.study.messagebus.consumer;
//
//
//import com.renrenche.jqn.study.dao.StudentDao;
//import com.renrenche.messagebus.client.annotation.Consumer;
//import com.renrenche.messagebus.client.enums.ConsumeFailedPolicy;
//import com.renrenche.messagebus.client.listener.AbstractMessageListener;
//import com.renrenche.messagebus.common.message.Message;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * 监听算法派单的消息
// *
// * @author jiangqiaonan
// */
//@Slf4j
//@Consumer(name = "distribution_task_algorithm_result_consumer", failedPolicy = ConsumeFailedPolicy.RETRY)
//public class PointAllocateSuccessListener extends AbstractMessageListener {
//
//    @Autowired
//    private StudentDao studentDao;
//
//    @Override
//    public void onMessage(Message message) {
//        try {
//            String body = message.getBody();
//            log.debug("接受到的消息是;rrcMessage=[{}],tag=[{}]", body, message.getHeader().getTag());
//            studentDao.insert(body);
//        } catch (Exception e) {
//            log.warn("消息消费异常;message={},e=[{}],", message, e.getMessage());
//            throw e;
//        }
//    }
//}
