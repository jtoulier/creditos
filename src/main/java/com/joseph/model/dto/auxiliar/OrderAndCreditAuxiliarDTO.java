package com.joseph.model.dto.auxiliar;

import com.joseph.model.dto.CreditDTO;
import com.joseph.model.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderAndCreditAuxiliarDTO {
    private OrderDTO order;
    private CreditDTO credit;
}
