package com.hisistant.auth.controller;

import com.hisistant.auth.domain.DailySales;
import com.hisistant.auth.domain.User;
import com.hisistant.auth.dto.DailySalesDTO;
import com.hisistant.auth.dto.UserDTO;
import com.hisistant.auth.service.SalesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {
    private final SalesService salesService;

    @GetMapping("/daily")
    public ResponseEntity<List<DailySalesDTO>> getDailySales(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO)session.getAttribute("user");
        Long user_id = user.getId();
        System.out.println(user_id);
        List<DailySalesDTO> dailySales = salesService.getDailySales(user_id);

        return ResponseEntity.ok(dailySales);
    }
}
