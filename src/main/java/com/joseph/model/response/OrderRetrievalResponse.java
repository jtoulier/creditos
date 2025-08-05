package com.joseph.model.response;

import com.joseph.model.response.auxiliar.CreditRetrievalAuxiliarResponse;
import com.joseph.model.response.auxiliar.OrderRetrievalAuxiliarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRetrievalResponse {
    private OrderRetrievalAuxiliarResponse order;
    private CreditRetrievalAuxiliarResponse credit;
}