package com.ironhack.productpriceedgeservice.Client;

import com.ironhack.productpriceedgeservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-proxy-service")
public interface ProductServiceClient {
    @GetMapping("/products/{id}")
    Product findById(@PathVariable Long id);

}
