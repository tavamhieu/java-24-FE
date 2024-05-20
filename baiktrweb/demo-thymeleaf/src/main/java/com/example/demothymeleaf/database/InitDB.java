package com.example.demothymeleaf.database;

import com.example.demothymeleaf.model.Product;
import com.example.demothymeleaf.untilfile.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitDB implements CommandLineRunner {

    @Autowired
    private IFileReader fileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Khởi tạo dữ liệu ban đầu cho ứng dụng");
        List<Product> products = fileReader.readFile("PRODUCTDATA.json");
        ProductDB.products = products;

        System.out.println("Số lượng Products = " + ProductDB.products.size());
    }
}
