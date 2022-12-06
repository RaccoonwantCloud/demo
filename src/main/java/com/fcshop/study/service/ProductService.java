package com.fcshop.study.service;

import com.fcshop.study.entity.product.Product;
import com.fcshop.study.entity.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    // 검색
    public List<Product> search(String pName){
        List<Product> searList = productRepository.findBypNameContaining(pName);
        return searList;
    }



}
