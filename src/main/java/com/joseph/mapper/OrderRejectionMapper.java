package com.joseph.mapper;

import com.joseph.model.dto.OrderDTO;
import com.joseph.model.request.OrderRejectionRequest;
import com.joseph.model.response.OrderRejectionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface OrderRejectionMapper {
    // From Request to DTO
    OrderDTO toOrderDTO(OrderRejectionRequest orderRejectionRequest);

    // From DTO to Response
    default OrderRejectionResponse toOrderRejectionResponse() {
        return new OrderRejectionResponse();
    }
}
