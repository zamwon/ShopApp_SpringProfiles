package pl.karnecki.shopapp.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.karnecki.shopapp.model.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class CartService {

    private List<Product> productList;

    public CartService() {

        Random random = new Random();
        final BigDecimal PRICE = new BigDecimal(random.nextDouble() * 250 + 50);

        Product product1 = new Product("Tablet", PRICE);
        Product product2 = new Product("Spodnie", PRICE);
        Product product3 = new Product("Buty", PRICE);
        Product product4 = new Product("Koszula", PRICE);
        Product product5 = new Product("Marynarka", PRICE);
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
