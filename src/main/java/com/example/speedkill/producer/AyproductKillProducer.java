package com.example.speedkill.producer;

import com.example.speedkill.model.AyUserKillProduct;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class AyproductKillProducer {
    //    Logger logger= (Logger) LoggerFactory.getLogger(ProductServiceImpl.class);
    @Resource
//    private AmqpTemplate amqpTemplate;
    private JmsMessagingTemplate jmsMessagingTemplate;

    //    public void sendMessage(AyproductKillProducer killProducer){
    public void sendMessage(Destination destination, final AyUserKillProduct killProduct) {
//        logger.info("ayprdoctu send message kill product is "+killProduct);
        jmsMessagingTemplate.convertAndSend(destination, killProduct);
//        amqpTemplate.convertAndSend("object",killProducer);
    }
}
