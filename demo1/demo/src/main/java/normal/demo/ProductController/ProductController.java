package normal.demo.ProductController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        // Tạo danh sách sản phẩm tại đây
        products.add(new Product("1", "iPhone 12", "The latest iPhone", 999, "Apple"));
        // Thêm các sản phẩm khác vào danh sách ở đây
        return products;
    }
}
