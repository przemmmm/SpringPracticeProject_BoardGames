package com.example.springpracticeproject_boardgames.session;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserSession {

    private String userEmail = "";

    public boolean emailIsEmpty(){
        return userEmail.isEmpty();
    }


}
