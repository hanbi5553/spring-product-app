package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repo;

    // 전체 목록 조회
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", repo.findAll());
        return "product/list";
    }

    // 등록 폼
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

    // 등록 처리
    @PostMapping
    public String create(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return "product/form";
        }
        repo.save(product);
        return "redirect:/products";
    }

    // 수정 폼
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Product product = repo.findById(id).orElseThrow();
        model.addAttribute("product", product);
        return "product/form";
    }

    // 수정 처리
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            model.addAttribute("product", product);
            return "product/form";
        }
        product.setId(id);
        repo.save(product);
        return "redirect:/products";
    }

    // 삭제
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/products";
    }
}
