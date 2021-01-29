package pl.karnecki.shopapp.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.karnecki.shopapp.model.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class CartService {

    private List<Product> productList;

    public CartService() {

        Random random = new Random();
        //BigDecimal price = new BigDecimal(random.nextDouble() * 250 + 50).setScale(2, RoundingMode.DOWN);

        Product product1 = new Product("Tablet", BigDecimal.valueOf(random.nextDouble() * 250 + 50).setScale(2, RoundingMode.DOWN));
        Product product2 = new Product("Spodnie", BigDecimal.valueOf(random.nextDouble() * 250 + 50).setScale(2, RoundingMode.DOWN));
        Product product3 = new Product("Buty", BigDecimal.valueOf(random.nextDouble() * 250 + 50).setScale(2, RoundingMode.DOWN));
        Product product4 = new Product("Koszula", BigDecimal.valueOf(random.nextDouble() * 250 + 50).setScale(2, RoundingMode.DOWN));
        Product product5 = new Product("Marynarka", BigDecimal.valueOf(random.nextDouble() * 250 + 50).setScale(2, RoundingMode.DOWN));

        productList = new ArrayList<>();

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

    }

    public List<Product> getProductList() {

        log.info("Zwracam liste produktow");
        return productList;
    }

    public BigDecimal getTotalPrice() {

        log.info("Zwracam calkowity koszt produktow w koszyku");

        BigDecimal total = new BigDecimal(0);
        for (Product p : productList) {
            total = total.add(p.getPrice());
        }
        return total;
    }
}
