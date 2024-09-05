package com.hisistant.auth.dto;

import lombok.Data;

@Data
public class SignUpDTO {
    private String username;
    private String password;
    private String store_name;
}
