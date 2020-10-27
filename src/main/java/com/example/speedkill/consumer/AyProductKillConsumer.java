package com.example.speedkill.consumer;

import com.example.speedkill.model.AyUserKillProduct;
import com.example.speedkill.service.AyUserKillProductService;
import com.example.speedkill.service.impl.ProductServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Component
public class AyProductKillConsumer {
//    Logger logger = (Logger) LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private AyUserKillProductService ayUserKillProductService;

    /**
     * 消费消息
     * @param killProduct
     */
    @JmsListener(destination = "queue.asyn.save")
    public void receiveQueue(AyUserKillProduct killProduct){
        //保存秒杀商品数据
        ayUserKillProductService.save(killProduct);
        //记录日志
//        logger.info("ayUserKillProductService save, and killProduct: " + killProduct);
    }

}
