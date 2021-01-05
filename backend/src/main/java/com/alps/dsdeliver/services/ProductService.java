package com.alps.dsdeliver.services;

import com.alps.dsdeliver.dto.ProductDTO;
import com.alps.dsdeliver.entities.Product;
import com.alps.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductDTO> findAll() {
      List<Product> products = repository.findAllByOrderByNameAsc();
      return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

}
