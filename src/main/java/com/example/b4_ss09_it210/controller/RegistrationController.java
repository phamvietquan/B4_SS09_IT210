package com.example.b4_ss09_it210.controller;

import org.example.session9_ex4.model.Seller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/register")
@SessionAttributes("seller")
public class RegistrationController {

    @ModelAttribute("seller")
    public Seller setUpSeller() {
        return new Seller();
    }

    @GetMapping("/step1")
    public String showStep1(Model model) {
        return "step1";
    }

    @PostMapping("/step1")
    public String processStep1(@ModelAttribute("seller") Seller seller) {
        return "redirect:/register/step2";
    }

    @GetMapping("/step2")
    public String showStep2(Model model) {
        return "step2";
    }

    @PostMapping("/step2")
    public String processStep2(@ModelAttribute("seller") Seller seller) {
        return "redirect:/register/step3";
    }

    @GetMapping("/step3")
    public String showStep3(Model model) {
        return "step3";
    }

    @PostMapping("/complete")
    public String processComplete(@ModelAttribute("seller") Seller seller, SessionStatus status) {

        System.out.println("ĐĂNG KÝ THÀNH CÔNG GIAN HÀNG:");
        System.out.println("Chủ shop: " + seller.getFullName() + " | Email: " + seller.getEmail());
        System.out.println("Tên shop: " + seller.getShopName() + " | Địa chỉ: " + seller.getShopAddress());

        status.setComplete();

        return "redirect:/register/success";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }
}