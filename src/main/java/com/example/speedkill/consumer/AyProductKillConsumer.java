package com.example.speedkill.consumer;

import com.example.speedkill.model.AyUserKillProduct;
import com.example.speedkill.service.AyUserKillProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class AyProductKillConsumer {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    //    Logger logger=LoggerFactory.getLogger(AyProductKillConsumer.class);
    @Resource
    private AyUserKillProductService ayUserKillProductService;

    /**
     * 消费消息
     *
     * @param killProduct
     */
    @JmsListener(destination = "queue.asyn.save")
    public void receiveQueue(AyUserKillProduct killProduct) {
        //保存秒杀商品数据
        ayUserKillProductService.save(killProduct);
        //记录日志
        logger.info("ayUserKillProductService save, and killProduct: " + killProduct);
        logger.error("sth wrong");
    }

}
