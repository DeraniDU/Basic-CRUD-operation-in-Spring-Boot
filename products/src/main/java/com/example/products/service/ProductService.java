package com.example.products.service;

import com.example.products.dto.ProductDTO;
import com.example.products.model.Product;
import com.example.products.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Retrieve all products
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        return modelMapper.map(productList, new TypeToken<List<ProductDTO>>() {}.getType());
    }

    // Save a product
    public ProductDTO saveProduct(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO, Product.class);

        // Save entity to database
        Product savedProduct = productRepo.save(product);

        // Map saved entity back to DTO
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    //update product
    public ProductDTO updateProduct(ProductDTO productDTO) {
        productRepo.save(modelMapper.map(productDTO, Product.class));
        return productDTO;
    }

    //delete product
    public String deleteProduct(ProductDTO productDTO) {
        productRepo.delete(modelMapper.map(productDTO, Product.class));
        return "User Deleted";
    }
}
