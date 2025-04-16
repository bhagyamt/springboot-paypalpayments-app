package com.cpt.payments.pojo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private String status;
    private String redirectURL;



}
