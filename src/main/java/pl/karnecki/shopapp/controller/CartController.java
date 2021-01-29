package pl.karnecki.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karnecki.shopapp.model.Product;
import pl.karnecki.shopapp.service.CartService;
import java.util.List;

@RestController
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/get")
    public List<Product> get(){
        return cartService.getProductList();
    }
}
