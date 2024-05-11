package baitapdemo.demo.baitap;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();


    public ProductController() {
        products.add(new Product("1", "Product A", "Description A", 100, "Brand A"));
        products.add(new Product("2", "Product B", "Description B", 150, "Brand B"));
        products.add(new Product("3", "Product C", "Description C", 200, "Brand A"));
        products.add(new Product("4", "Product D", "Description D", 250, "Brand C"));
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    @GetMapping("/name-starts/{prefix}")
    public List<Product> getProductsByNameStartsWith(@PathVariable String prefix) {
        return products.stream()
                .filter(product -> product.getName().startsWith(prefix))
                .collect(Collectors.toList());
    }


    @GetMapping("/price/{min}/{max}")
    public List<Product> getProductsByPriceRange(@PathVariable int min, @PathVariable int max) {
        return products.stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                .collect(Collectors.toList());
    }


    @GetMapping("/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable String brand) {
        return products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }


    @GetMapping("/brand/{brand}/max-price")
    public Product getProductWithMaxPriceByBrand(@PathVariable String brand) {
        return products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .max((p1, p2) -> p1.getPrice() - p2.getPrice())
                .orElse(null);
    }
}
