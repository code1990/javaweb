package com.controller;

import com.Order;
import com.Product;
import com.alibaba.fastjson.JSONObject;
import com.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-12 21:51
 * @Author: code1990
 * @Description:
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;



    @RequestMapping("/order/product/{pid}")
    public Order createOrder(@PathVariable("pid") Integer pid) {
//        List<ServiceInstance> list = discoveryClient.getInstances("product-service");
//        int index = new Random(list.size()).nextInt();
//        ServiceInstance instance = list.get(index);
        String url = "service-product";
        Product product = restTemplate.getForObject("http://"+url+"/product/" + pid, Product.class);
        log.info(JSONObject.toJSONString(product));
        Order order = new Order();
        order.setNumber(1);
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setUsername("test");
        order.setUid(1);
        orderService.save(order);
        log.info(JSONObject.toJSONString(order));
        return order;
    }

//    @RequestMapping("/order/product/{pid}")
//    public Order createOrder(@PathVariable("pid") Integer pid) {
//        List<ServiceInstance> list = discoveryClient.getInstances("product-service");
//        int index = new Random(list.size()).nextInt();
//        ServiceInstance instance = list.get(index);
//        String url = instance.getHost() + ":" + instance.getPort();
//        Product product = restTemplate.getForObject("http://" + url + "/product/" + pid, Product.class);
//        log.info(JSONObject.toJSONString(product));
//        Order order = new Order();
//        order.setNumber(1);
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setUsername("test");
//        order.setUid(1);
//        orderService.save(order);
//        log.info(JSONObject.toJSONString(order));
//        return order;
//    }

//    @RequestMapping("/order/product/{pid}")
//    public Order createOrder(@PathVariable("pid") Integer pid) {
//        ServiceInstance instance = discoveryClient.getInstances("product-service").get(0);
//        String url = instance.getHost() + ":" + instance.getPort();
//        Product product = restTemplate.getForObject("http://" + url + "/product/" + pid, Product.class);
//        log.info(JSONObject.toJSONString(product));
//        Order order = new Order();
//        order.setNumber(1);
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setUsername("test");
//        order.setUid(1);
//        orderService.save(order);
//        log.info(JSONObject.toJSONString(order));
//        return order;
//    }

//    @RequestMapping("/order/product/{pid}")
//    public Order createOrder(@PathVariable("pid") Integer pid) {
//        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
//        log.info(JSONObject.toJSONString(product));
//        Order order = new Order();
//        order.setNumber(1);
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setUsername("test");
//        order.setUid(1);
//        orderService.save(order);
//        log.info(JSONObject.toJSONString(order));
//        return order;
//    }
}
