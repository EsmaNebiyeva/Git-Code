package org.example.project.service.other;

import org.example.project.entity.other.Product;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    boolean deleteProduct(Product product);
    boolean deleteProductById(Long id);
    Product updateProduct(Long id,Product product);
    Product getProductById(Long id);
    List<Product> getProducts(Integer page, Integer size);
    List<Product> getProducts();
    Product updateProductWithCancel(Long id, Product product);
    List<Product> getProductByName(String name);
    Boolean existsProductByReceiptNo(String receiptNo);
    Long getCategoryCount();

}
