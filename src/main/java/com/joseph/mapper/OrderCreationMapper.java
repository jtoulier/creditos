package com.joseph.mapper;

import com.joseph.model.dto.CreditDTO;
import com.joseph.model.dto.OrderDTO;
import com.joseph.model.request.OrderCreationRequest;
import com.joseph.model.response.OrderCreationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface OrderCreationMapper {
    // From Request to DTO
    @Mapping(source = "order.businessId", target = "businessId")
    @Mapping(source = "order.businessName", target = "businessName")
    @Mapping(source = "author", target = "author")
    OrderDTO toOrderTO(OrderCreationRequest orderCreationRequest);

    @Mapping(source = "credit.amount", target = "amount")
    @Mapping(source = "credit.interestRate", target = "interestRate")
    @Mapping(source = "credit.dueDate", target = "dueDate")
    @Mapping(source = "author", target = "author")
    CreditDTO toCreditTO(OrderCreationRequest orderCreationRequest);

    // From DTO to Response : Main
    OrderCreationResponse toOrderCreationResponse(Long orderId);
}
