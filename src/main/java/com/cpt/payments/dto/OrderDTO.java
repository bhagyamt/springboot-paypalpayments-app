package com.cpt.payments.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String orderId;
    private String status;
    private String redirectURL;



}
