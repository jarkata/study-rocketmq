package org.apache.rocketmq.client.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestDefaultProducer {

    @Test
    public void test() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("PX",true);
        producer.setNamesrvAddr("localhost:9876");
        producer.setRetryAnotherBrokerWhenNotStoreOK(true);
        producer.start();
        for(int index =0; index<1000;index++){
            Message message = new Message("test_trace",(System.currentTimeMillis()+"message-"+index).getBytes(StandardCharsets.UTF_8));
            SendResult send = producer.send(message,2000L);
            System.out.println(send);
        }

//        producer.shutdown();
    }

    @Test
    public void testUserHome(){
        String property = System.getProperty("user.home");
        System.out.println(property);

    }
}
