package com.cpt.payments.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;
// Ensure the correct package path for PaypalProviderCreateOrderReq
import com.cpt.payments.pojo.PaypalProviderCreateOrderReq; // Ensure this class exists in the specified package or update the path
import com.cpt.payments.service.interfaces.PaymentService;
import com.cpt.payments.dto.CreateOrderReqDTO;
import com.cpt.payments.pojo.Order; // Ensure this class exists in the specified package or create it if missing
import com.cpt.payments.dto.OrderDTO; // Ensure this class exists in the specified package or create it if missing

/*
 * This is a sample controller class for handling payment-related requests.
 */
@RestController
@RequestMapping("/v1/paypal/order")
public class PaymentController {

    private ModelMapper modelMapper;

    private  PaymentService paymentService; // Assuming you have a PaymentService interface

    // Constructor injection of ModelMapper
    public PaymentController(ModelMapper modelMapper, PaymentService paymentService) {
        this.modelMapper = modelMapper;
        this.paymentService = paymentService; // Initialize the paymentService
    }
    /**
     * * This method handles the creation of an order.
     * @param createOrderReq
     * @return Order
     */
    @PostMapping
    public Order createOrder(@RequestBody PaypalProviderCreateOrderReq createOrderReq) {
        
        System.out.println("order created request received createOrderReq" + createOrderReq);

        
        CreateOrderReqDTO reqDTO = modelMapper.map(createOrderReq, CreateOrderReqDTO.class);
        System.out.println("converted req pojo to DTO reqDTO:" + reqDTO);

        OrderDTO responseDTO=paymentService.createOrder(reqDTO);
        System.out.println("received response from responseDTO:" + responseDTO);
    

        Order order =modelMapper.map(responseDTO, Order.class);
        System.out.println("converted service response to POJO & returning order :" + order);

    
        return order;
    }


}
