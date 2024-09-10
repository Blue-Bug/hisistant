package com.hisistant.auth.controller;

import com.hisistant.auth.domain.Menu;
import com.hisistant.auth.domain.Order;
import com.hisistant.auth.domain.User;
import com.hisistant.auth.dto.*;
import com.hisistant.auth.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDTO>> getCategory(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        Long user_id = user.getId();
        System.out.println(user_id);
        List<CategoryDTO> categories = orderService.getCategories(user_id);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/menu/{category_id}")
    public ResponseEntity<List<MenuDTO>> getMenu(HttpServletRequest request, @PathVariable Long category_id) {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        Long user_id = user.getId();
        System.out.println(user_id);
        List<MenuDTO> categoryMenus = orderService.getCategoryMenu(user_id, category_id);
        return ResponseEntity.ok(categoryMenus);
    }

    @PostMapping("/confirm")
    public ResponseEntity<Order> confirm(HttpServletRequest request,@RequestBody OrderDTO orderDTO) {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        Long user_id = user.getId();

        Order order = orderService.confirmOrder(user_id, orderDTO);
        return ResponseEntity.created(URI.create("/"+order.getId())).body(order);
    }
}
