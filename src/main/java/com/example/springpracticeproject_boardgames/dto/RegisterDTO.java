package com.example.springpracticeproject_boardgames.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RegisterDTO {
    private String userEmail;
    private String password1;
    private String password2;


}
