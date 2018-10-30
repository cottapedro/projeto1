package br.com.rpg.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class LoginAPI {

    @RequestMapping(value="/login",  method= RequestMethod.GET)
    public String login(){
        return "localhost:4200/login";
    }
}
