package pl.karnecki.shopapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Component
@Slf4j
public class Cart {

    private ArrayList<Product> getProductList;


}
