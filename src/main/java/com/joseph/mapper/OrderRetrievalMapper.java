package com.joseph.mapper;

import com.joseph.model.dto.CreditDTO;
import com.joseph.model.dto.OrderDTO;
import com.joseph.model.response.OrderRetrievalResponse;
import com.joseph.model.response.auxiliar.CreditRetrievalAuxiliarResponse;
import com.joseph.model.response.auxiliar.OrderRetrievalAuxiliarResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi") // Para integración con Quarkus
public interface OrderRetrievalMapper {
    // From DTO to Response : Auxiliar
    CreditRetrievalAuxiliarResponse toCreditAuxiliarResponse(CreditDTO creditDTO);
    OrderRetrievalAuxiliarResponse toOrderAuxiliarResponse(OrderDTO orderDTO);

    // From DTO to Response : Main
    default OrderRetrievalResponse toOrderRetrievalResponse(OrderDTO orderDTO, CreditDTO creditDTO) {
        OrderRetrievalResponse response = new OrderRetrievalResponse();
        response.setOrder(toOrderAuxiliarResponse(orderDTO));
        response.setCredit(toCreditAuxiliarResponse(creditDTO));
        return response;
    }
}