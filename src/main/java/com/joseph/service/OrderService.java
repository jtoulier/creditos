package com.joseph.service;

import com.joseph.model.dto.CreditDTO;
import com.joseph.model.dto.OrderDTO;
import com.joseph.model.dto.auxiliar.OrderAndCreditAuxiliarDTO;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@ApplicationScoped
public class OrderService {

    public OrderAndCreditAuxiliarDTO getOrder(
            Long orderId
    ) {
        // Logica de lectura
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderId);
        orderDTO.setBusinessId("20509381667");
        orderDTO.setBusinessName("PERUMUNDO TOURS EIRL");
        orderDTO.setOrderState("EN PROCESO");
        orderDTO.setWrittenAt(LocalDateTime.now());
        orderDTO.setAuthor("JOSEPH");

        CreditDTO creditDTO = new CreditDTO();
        creditDTO.setOrderId(orderId);
        creditDTO.setAmount(BigDecimal.valueOf(125.32));
        creditDTO.setInterestRate(BigDecimal.valueOf(6.25));
        creditDTO.setDueDate(LocalDate.now());
        creditDTO.setWrittenAt(LocalDateTime.now());
        creditDTO.setAuthor("JOSEPH");

        OrderAndCreditAuxiliarDTO orderAndCreditAuxiliarDTO = new OrderAndCreditAuxiliarDTO();
        orderAndCreditAuxiliarDTO.setOrder(orderDTO);
        orderAndCreditAuxiliarDTO.setCredit(creditDTO);

        // Retorno
        return orderAndCreditAuxiliarDTO;
    }

    public Long createOrder(
        OrderDTO orderDTO,
        CreditDTO creditDTO
    ) {
        // Logica de creacion
        // log.info(orderDTO.toString());
        // log.info(creditDTO.toString());

        Long orderId = 126L;

        // Retorno
        return orderId;
    }

    public void approveOrder(
        OrderDTO orderDTO
    ) {
        // Logica de aprobacion
        orderDTO.setOrderState("APROBADO");
        orderDTO.setWrittenAt(LocalDateTime.now());

        // log.info(orderDTO.toString());

        // Retorno
    }

    public void rejectOrder(
        OrderDTO orderDTO
    ) {
        // Logica de desaprobacion
        orderDTO.setOrderState("DESAPROBADO");
        orderDTO.setWrittenAt(LocalDateTime.now());

        // log.info(orderDTO.toString());

        // Retorno
    }
}