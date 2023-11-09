package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.CalculateIvaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CalculateIvaAdapter implements CalculateIvaService {

    @Override
    @Transactional
    public void calculateIva(Product product) {
        double alcoholPercentage = product.getAlcoholPercentage();
        double price = product.getPrice();

        // Calcular el IVA
        double iva = (alcoholPercentage * price) / 100;

        // Sumar el IVA al precio
        double newPrice = price + iva;

        // Establecer el IVA en el producto
        product.setIva(iva);

        // Establecer el nuevo precio en el producto
        product.setPrice(newPrice);
    }
}

