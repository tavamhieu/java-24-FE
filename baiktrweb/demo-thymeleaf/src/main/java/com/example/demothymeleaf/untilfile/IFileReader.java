package com.example.demothymeleaf.untilfile;

import com.example.demothymeleaf.model.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String filePath);
}
