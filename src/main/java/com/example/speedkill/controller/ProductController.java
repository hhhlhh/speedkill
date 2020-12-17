package com.example.speedkill.controller;

import com.example.speedkill.model.AyProduct;
import com.example.speedkill.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Resource
    private ProductService productService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询所有的商品
     *
     * @param model
     * @return
     */
    @RequestMapping("/all")
    public String findAll(Model model) {
        List<AyProduct> products = productService.findAll();
        model.addAttribute("products", products);
        return "product_list";
    }

    /**
     * 查询所有的商品（缓存）
     *
     * @param model
     * @return
     */
    @RequestMapping("/all/cache")
    public String findAllCache(Model model) {
        Collection<AyProduct> products = productService.findAllCache();
        model.addAttribute("products", products);
        return "product_list";
    }

    /**
     * 秒杀商品
     *
     * @param model
     * @param productId 商品id
     * @param userId    用户id
     * @return
     */
    @RequestMapping("/{id}/kill")
    public String killProduct(Model model,
                              @PathVariable("id") Integer productId,
                              @RequestParam("userId") Integer userId) {
        AyProduct ayProduct = productService.killProduct(productId, userId);
        if (null != ayProduct) {
            return "success";

        }
        logger.info("kill id" + productId + userId);
        return "fail";
    }
}
