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
        double price = product.getPrice();
        // Verificar la categoría del producto
        long categoryId = product.getCategory().getId();

        // Definir las tasas de IVA y consumo según la categoría
        double ivaRate = (categoryId == 6) ? 0.19 : 0.15;
        double consumo = (categoryId != 6) ? price * 0.23 : 0.0;

        // Calcular el IVA
        double iva = price * ivaRate;

        // Sumar el IVA y el consumo al precio
        double newPrice = price + iva + consumo;

        // Establecer el IVA en el producto
        product.setIva(iva);

        // Establecer el Consumo en el producto
        product.setConsumo(consumo);

        // Establecer el nuevo precio en el producto
        product.setPrice(newPrice);
    }

}
