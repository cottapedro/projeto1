package br.com.rpg.api;

import br.com.rpg.config.Global;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RequiredArgsConstructor
@RestController
public class LoginAPI {

    @GetMapping(value="/login")
    public void login(HttpServletResponse httpResponse)throws Exception {
        httpResponse.sendRedirect(Global.url + "/login");
    }
}
