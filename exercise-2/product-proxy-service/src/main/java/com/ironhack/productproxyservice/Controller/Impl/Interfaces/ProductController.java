package com.ironhack.productproxyservice.Controller.Impl.Interfaces;

import com.ironhack.productproxyservice.Model.Product;

public interface ProductController {
    Product findById(Long id);
}
