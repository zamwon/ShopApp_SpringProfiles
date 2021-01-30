package pl.karnecki.shopapp.service;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import pl.karnecki.shopapp.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@Setter
@ConfigurationProperties(prefix = "shop-values")
public class CartService {

    private List<Product> productList;

    private double tax;
    private int discount;

    final double TAX = (1 + tax / 100);

    public CartService() {

        Random random = new Random();
        //BigDecimal price = new BigDecimal(random.nextDouble() * 250 + 50).setScale(2, RoundingMode.DOWN);

        final int DISCOUNT = (1 - discount / 100);


        Product product1 = new Product("Tablet", BigDecimal.valueOf(
                (random.nextDouble() * 250 + 50) * DISCOUNT)
                .setScale(2, RoundingMode.DOWN));
        Product product2 = new Product("Spodnie", BigDecimal.valueOf(
                (random.nextDouble() * 250 + 50) * DISCOUNT)
                .setScale(2, RoundingMode.DOWN));
        Product product3 = new Product("Buty", BigDecimal.valueOf(
                (random.nextDouble() * 250 + 50) * DISCOUNT)
                .setScale(2, RoundingMode.DOWN));
        Product product4 = new Product("Koszula", BigDecimal.valueOf(
                (random.nextDouble() * 250 + 50) * DISCOUNT)
                .setScale(2, RoundingMode.DOWN));
        Product product5 = new Product("Marynarka", BigDecimal.valueOf(
                (random.nextDouble() * 250 + 50) * DISCOUNT)
                .setScale(2, RoundingMode.DOWN));

        productList = new ArrayList<>();

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

    }

    public List<Product> getProductList() {

        log.info("Zwracam liste produktow z uwzględnieniem rabatu w wysokosci " + discount + "%");
        return productList;
    }

    public BigDecimal getTotalPrice() {


        log.info("Zwracam calkowity koszt produktow w koszyku");

        BigDecimal total = new BigDecimal(0);
        for (Product p : productList) {
            total = total.add(p.getPrice());
        }
        log.info("Zawartość koszyka wynosi " + total + " , w tym " + tax + "% podatku (" +
                total.multiply(BigDecimal.valueOf(tax / 100)).setScale(2, RoundingMode.UP) + ")");

        return total.multiply(BigDecimal.valueOf(TAX)).setScale(2, RoundingMode.UP);
    }
}
