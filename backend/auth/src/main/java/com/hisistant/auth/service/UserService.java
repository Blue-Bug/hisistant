package com.hisistant.auth.service;

import com.hisistant.auth.domain.User;
import com.hisistant.auth.dto.SignUpDTO;
import com.hisistant.auth.dto.UserDTO;
import com.hisistant.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<UserDTO> login(String username, String password) {
        Optional<User> byUserId = userRepository.findByUsername(username);

        if(byUserId.isPresent()) {
            User user = byUserId.get();
            if(passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(UserDTO.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .store_name(user.getStore_name())
                        .build());
            }
        }

        return Optional.empty();
    }

    public Optional<UserDTO> signup(SignUpDTO signUpDTO) {
        User user = User.builder()
                .username(signUpDTO.getUsername())
                .password(passwordEncoder.encode(signUpDTO.getPassword()))
                .store_name(signUpDTO.getStore_name())
                .join_date(LocalDateTime.now())
                .build();

        user = userRepository.save(user);
        return Optional.of(UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .store_name(user.getStore_name())
                    .build());
    }
}
