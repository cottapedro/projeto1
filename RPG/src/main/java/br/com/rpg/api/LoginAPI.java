package br.com.rpg.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpg.config.Global;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class LoginAPI {

    @GetMapping(value="/login")
    public void login(HttpServletResponse httpResponse)throws Exception {
        httpResponse.sendRedirect(Global.url + "/login");
    }
}
