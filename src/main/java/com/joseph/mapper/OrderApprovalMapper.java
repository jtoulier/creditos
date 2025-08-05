package com.joseph.mapper;

import com.joseph.model.dto.OrderDTO;
import com.joseph.model.request.OrderApprovalRequest;
import com.joseph.model.response.OrderApprovalResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface OrderApprovalMapper {
    // From Request to DTO
    OrderDTO toOrderDTO(OrderApprovalRequest orderApprovalRequest);

    // From DTO to Response
    default OrderApprovalResponse toOrderApprovalResponse() {
        return new OrderApprovalResponse();
    }
}
