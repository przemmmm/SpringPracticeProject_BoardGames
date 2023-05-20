package com.example.springpracticeproject_boardgames.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LoginDTO {
    private String customerEmail;
    private String password;

    public LoginDTO(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
