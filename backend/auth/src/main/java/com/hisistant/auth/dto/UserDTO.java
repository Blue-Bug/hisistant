package com.hisistant.auth.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@Valid
public class UserDTO {
    @NotBlank
    private Long id;
    @Length(min=3,max=10)
    private String username;
    @Length(min=1,max=30)
    private String store_name;
}
