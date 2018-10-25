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
        return "<!DOCTYPE html>\n" +
                "<html\n" +
                "    xmlns:th=\"http://www.thymeleaf.org\"\n" +
                "    xmlns:layout=\"http://www.ultraq.net.nz/thymeleaf/layout\"\n" +
                "    xmlns:layout=\"http://www.ultraq.net.nz/thymeleaf/layout\"\n" +
                ">\n" +
                "\t<head>\n" +
                "\t    <title>Spring Security</title>\n" +
                "\n" +
                "\t    <link th:href=\"@{/webjars/bootstrap/css/bootstrap.min.css}\" rel=\"stylesheet\"/>\n" +
                "\n" +
                "\t    <link th:href=\"@{/webjars/bootstrap/css/bootstrap-theme.min.css}\" rel=\"stylesheet\"/>\n" +
                "\n" +
                "\t    <link th:href=\"@{/webjars/font-awesome/css/font-awesome.min.css}\" rel=\"stylesheet\"/>\n" +
                "\n" +
                "\t    <link th:href=\"@{/css/style.css}\" rel=\"stylesheet\"/>\n" +
                "\t</head>\n" +
                "\n" +
                "\t<body style=\"background-color: #f9f9f9\">\n" +
                "\t\t<div class=\"row\">\n" +
                "\t\t\t<div class=\"col-sm-4 col-sm-offset-4\">\n" +
                "\t\t\t\t<div th:if=\"${param.error}\">\n" +
                "\t\t\t\t\t<div class=\"alert alert-danger\">Usuário e/ou inválidos!</div>\n" +
                "\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t<div th:if=\"${param.logout}\">\n" +
                "\t\t\t\t\t<div class=\"alert alert-info\">Até logo!</div>\n" +
                "\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t<div class=\"panel panel-info\">\n" +
                "\t\t\t\t\t<div class=\"panel-heading\">\n" +
                "\t\t\t\t    \t<h3 class=\"panel-title\">ENTRE</h3>\n" +
                "\t\t\t\t  \t</div>\n" +
                "\t\t\t\t\t<div class=\"panel-body\">\n" +
                "\t\t\t\t\t\t<form action=\"/login\" method=\"post\">\n" +
                "\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t<input name=\"username\" class=\"form-control\" placeholder=\"Usuário\"/>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t<input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Senha\"/>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t<button class=\"btn btn-primary btn-block\">Entrar</button>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "<!--\n" +
                "\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"remember-me\" name=\"remember-me\" />\n" +
                "\t\t\t\t\t\t\t\t<label for=\"remember-me\">Lembrar?</label>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "-->\n" +
                "\t\t\t\t\t\t\t<input type=\"hidden\" th:name=\"${_csrf.parameterName}\" th:value=\"${_csrf.token}\" />\n" +
                "\t\t\t\t\t\t</form>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t\t<script th:src=\"@{/webjars/jquery/jquery.min.js}\"></script>\n" +
                "\n" +
                "\t\t<script th:src=\"@{/webjars/bootstrap/js/bootstrap.min.js}\"></script>\n" +
                "\t</body>\n" +
                "</html>";
    }
}
