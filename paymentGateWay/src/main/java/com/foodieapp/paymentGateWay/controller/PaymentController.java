package com.foodieapp.paymentGateWay.controller;

import com.foodieapp.paymentGateWay.domain.MyOrder;
import com.foodieapp.paymentGateWay.repository.MyOrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/payment")
public class PaymentController {


    private MyOrderRepository myOrderRepository;
    @Autowired
    public PaymentController(MyOrderRepository myOrderRepository){
        this.myOrderRepository=myOrderRepository;
    }

    @PostMapping("/create_order")
    @ResponseBody
    public String createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {
        System.out.println(data);

        int amt=Integer.parseInt(data.get("amount").toString());

       var client= new RazorpayClient("rzp_test_LP91fzOg59Pohi","H1ohtNvYEEO8YxskcB02URs1");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("amount",amt*100);
        jsonObject.put("currency","INR");
        jsonObject.put("receipt","txt_23456");

        Order order = client.orders.create(jsonObject);
        System.out.println(order);

        MyOrder myOrder=new MyOrder();

        myOrder.setAmount(order.get("amount")+"");
        myOrder.setOrderId(order.get("id"));
        myOrder.setPaymentId(null);
        myOrder.setStatus("created");
        myOrder.setReceipt(order.get("receipt"));

        myOrderRepository.save(myOrder);

        return order.toString();
    }
}
