package com.alps.dsdeliver.resources;

import com.alps.dsdeliver.dto.OrderDTO;
import com.alps.dsdeliver.dto.ProductDTO;
import com.alps.dsdeliver.services.OrderService;
import com.alps.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO orderDTO) {
        orderDTO = service.insert(orderDTO);
        
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(orderDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(orderDTO);
    }

}
