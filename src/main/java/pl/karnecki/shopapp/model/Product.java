package pl.karnecki.shopapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Product {

    private String productName;
    private BigDecimal price;


}

