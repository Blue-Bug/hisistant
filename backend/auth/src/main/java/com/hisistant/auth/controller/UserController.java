package com.hisistant.auth.controller;

import com.hisistant.auth.dto.LoginDTO;
import com.hisistant.auth.dto.SignUpDTO;
import com.hisistant.auth.dto.UserDTO;
import com.hisistant.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {
        Optional<UserDTO> user = userService.login(loginDTO.getUsername(), loginDTO.getPassword());

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO) {
        Optional<UserDTO> user = userService.signup(signUpDTO);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
