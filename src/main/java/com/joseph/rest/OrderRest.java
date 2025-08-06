package com.joseph.rest;

import com.joseph.mapper.OrderApprovalMapper;
import com.joseph.mapper.OrderCreationMapper;
import com.joseph.mapper.OrderRejectionMapper;
import com.joseph.mapper.OrderRetrievalMapper;
import com.joseph.model.dto.CreditDTO;
import com.joseph.model.dto.OrderDTO;
import com.joseph.model.dto.auxiliar.OrderAndCreditAuxiliarDTO;
import com.joseph.model.request.OrderApprovalRequest;
import com.joseph.model.request.OrderCreationRequest;
import com.joseph.model.request.OrderRejectionRequest;
import com.joseph.model.response.OrderCreationResponse;
import com.joseph.model.response.OrderRetrievalResponse;
import com.joseph.service.OrderService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderRest {

    @Inject
    OrderService orderService;

    @Inject
    OrderRetrievalMapper orderRetrievalMapper;

    @Inject
    OrderCreationMapper orderCreationMapper;

    @Inject
    OrderApprovalMapper orderApprovalMapper;

    @Inject
    OrderRejectionMapper orderRejectionMapper;

    @POST
    @Path("/")
    public Response createOrder(
        OrderCreationRequest orderCreationRequest
    ) {
        log.info("createOrder REQUEST: orderCreationRequest={}", orderCreationRequest);

        // Map Request to DTO
        OrderDTO orderDTO = orderCreationMapper.toOrderTO(orderCreationRequest);
        CreditDTO creditDTO = orderCreationMapper.toCreditTO(orderCreationRequest);

        // Invoke logic
        Long orderId = orderService.createOrder(orderDTO, creditDTO);

        // Map DTO to Response
        OrderCreationResponse orderCreationResponse = orderCreationMapper.toOrderCreationResponse(orderId);

        // Return
        log.info("createOrder RESPONSE: orderCreationResponse={}", orderCreationResponse);
        return Response
                .status(Response.Status.CREATED)
                .entity(orderCreationResponse)
                .build();
    }

    @GET
    @Path("/{orderId}")
    public Response getOrder(
        @PathParam("orderId") Long orderId
    ) {
        log.info("getOrder REQUEST: orderId={}", orderId);

        // Invoke logic
        OrderAndCreditAuxiliarDTO orderAndCreditAuxiliarDTO = orderService.getOrder(orderId);

        // Map DTO to Response
        OrderRetrievalResponse orderRetrievalResponse =
            orderRetrievalMapper
                .toOrderRetrievalResponse(
                    orderAndCreditAuxiliarDTO.getOrder(),
                    orderAndCreditAuxiliarDTO.getCredit()
                );

        // Return
        log.info("getOrder RESPONSE: orderRetrievalResponse={}", orderRetrievalResponse);
        return Response
                .ok(orderRetrievalResponse)
                .build();
    }

    @PATCH
    @Path("/{orderId}/approve")
    public Response approveOrder(
        @PathParam("orderId") Long orderId,
        OrderApprovalRequest orderApprovalRequest
    ) {
        log.info("approveOrder REQUEST: orderId={} orderApprovalRequest={}", orderId, orderApprovalRequest);

        // From Request to DTO
        OrderDTO orderDTO = orderApprovalMapper.toOrderDTO(orderApprovalRequest);
        orderDTO.setOrderId(orderId);

        // Invocar logica
        orderService.approveOrder(orderDTO);

        // From DTO to Response
        log.info("approveOrder RESPONSE: ");
        return Response
                .noContent()
                .build();
    }

    @PATCH
    @Path("/{orderId}/reject")
    public Response rejectOrder(
        @PathParam("orderId") Long orderId,
        OrderRejectionRequest orderRejectionRequest
    ) {
        log.info("rejectOrder REQUEST: orderId={} orderRejectionRequest={}", orderId, orderRejectionRequest);

        // From Request to DTO
        OrderDTO orderDTO = orderRejectionMapper.toOrderDTO(orderRejectionRequest);
        orderDTO.setOrderId(orderId);

        // Invocar logica
        orderService.rejectOrder(orderDTO);

        // From DTO to Response
        log.info("rejectOrder RESPONSE: ");
        return Response
                .noContent()
                .build();
    }
}
