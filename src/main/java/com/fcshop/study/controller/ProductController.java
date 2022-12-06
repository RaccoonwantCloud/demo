package com.fcshop.study.controller;

import com.fcshop.study.entity.product.Product;
import com.fcshop.study.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public String viewProductList(Model model){

        List<Product> products = productService.findAll();
        model.addAttribute("products",products);

        return "index";
    }

    @GetMapping("/searchProduct")
    public String search(Model model, String pName) {
        System.out.println("검색");
        List<Product> searchList = productService.search(pName);
        model.addAttribute("searchList", searchList);
        for (int i=0; i<=searchList.size(); i++ ){
            System.out.println("검색된 값: " + searchList);
        }
        return "productDetail";
    }


}
