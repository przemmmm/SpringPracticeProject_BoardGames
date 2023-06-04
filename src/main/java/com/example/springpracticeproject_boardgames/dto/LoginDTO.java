package com.example.springpracticeproject_boardgames.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LoginDTO {
    private String userEmail;
    private String password;

    }

