package com.hisistant.auth.controller;

import com.hisistant.auth.domain.Menu;
import com.hisistant.auth.domain.User;
import com.hisistant.auth.dto.CategoryDTO;
import com.hisistant.auth.dto.MenuDTO;
import com.hisistant.auth.dto.UserDTO;
import com.hisistant.auth.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.List;

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
}
