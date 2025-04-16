package com.cpt.payments.service.impl;

import org.springframework.stereotype.Service;
import com.cpt.payments.dto.CreateOrderReqDTO; // Import the missing class
import com.cpt.payments.dto.OrderDTO;
import com.cpt.payments.service.interfaces.PaymentService; // Updated to the correct package path

// If the interface is in a different package, update the import to the correct path, e.g.:
// import com.cpt.payments.api.PaymentService;

@Service
public class PaymentServiceimpl implements PaymentService {
    // Implement the methods defined in the PaymentService interface here
    // For example:
     @Override
    public OrderDTO createOrder(CreateOrderReqDTO createOrderReqDTO) {
        
       System.out.println("creating order for " + "createOrderReqDTO:" + createOrderReqDTO);
        
       OrderDTO orderDTO = new OrderDTO();
       
        orderDTO.setStatus("CREATED");
        orderDTO.setRedirectURL("http://localhost:8083/v1/order/1234"); 
        orderDTO.setOrderId("1234");


        System.out.println("Returning created orderDTO:" + orderDTO);

         return orderDTO;
 
     }

    }

