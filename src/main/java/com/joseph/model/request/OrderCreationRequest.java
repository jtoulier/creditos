package com.joseph.model.request;

import com.joseph.model.request.auxiliar.CreditCreationAuxiliarRequest;
import com.joseph.model.request.auxiliar.OrderCreationAuxiliarRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationRequest {
    private OrderCreationAuxiliarRequest order;
    private CreditCreationAuxiliarRequest credit;
    private String author;
}
