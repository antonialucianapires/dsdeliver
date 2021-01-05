package com.alps.dsdeliver.services;

import com.alps.dsdeliver.dto.OrderDTO;
import com.alps.dsdeliver.dto.ProductDTO;
import com.alps.dsdeliver.entities.Order;
import com.alps.dsdeliver.entities.Product;
import com.alps.dsdeliver.repositories.OrderRepository;
import com.alps.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

}