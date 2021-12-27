package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productSv")
    private IProductService productService;

    @GetMapping("")
    private String showIndex(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/view";
    }

    @GetMapping("/create")
    private String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    private String saveProduct(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    private String editProduct(@PathVariable(name = "id") String id,
                               Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    private String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable(name = "id") String id) {
        productService.remove(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/viewDetail")
    private String viewDetail(@PathVariable(name = "id") String id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "/viewDetail";
    }
   /* @GetMapping()
    private String searchByName(){
        return null;
    }*/
}