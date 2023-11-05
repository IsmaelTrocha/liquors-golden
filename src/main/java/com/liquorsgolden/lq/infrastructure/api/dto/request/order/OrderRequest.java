package com.liquorsgolden.lq.infrastructure.api.dto.request.order;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    @Schema(name = "customerId",
            description = "ID del cliente, campo obligatorio",
            example = "1",
            type = "Number")

    @NotNull(message = "El customerId no puede ser nulo")
    private Long customerId;

    @Schema(name = "addressId",
            description = "ID de la dirección de entrega, campo obligatorio",
            example = "1",
            type = "Number")

    @NotNull(message = "El addressId no puede ser nulo")
    private Long addressId;

    @Schema(name = "statusId",
            description = "ID del estado de la orden, campo obligatorio",
            example = "1",
            type = "Number")

    @NotNull(message = "El statusId no puede ser nulo")
    private Long statusId;

    @Schema(name = "productIds",
            description = "Lista de IDs de productos, campo obligatorio",
            example = "[1, 2, 3]",
            type = "Array of Numbers")

    @NotNull(message = "La lista de productIds no puede ser nula")
    private List<Long> productIds;

}
