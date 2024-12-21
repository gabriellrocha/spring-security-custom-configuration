package com.example.spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greet(HttpServletRequest request)  {

        /* Session - manter o estado entre múltiplas requisições HTTP, feitas pelo mesmo cliente
        já que o protocolo HTTP é sem estado*/

        // Com Session é possível:
        /*
        * autentificação - armazenar dados de login do usuário
        * preferências - guardar configurações ou escolhas feitas pelo usuário
        * dados temporários - manter intens de um carrinho de compra, progresso no formulário etc
        * */

        // Funciona atribuindo um ID de sessão único ao usuário (geralmente por cookies)


        return "Hello World! My Session ID is " + request.getSession().getId();
    }

}
