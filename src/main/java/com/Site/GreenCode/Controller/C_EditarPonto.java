package com.Site.GreenCode.Controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class C_EditarPonto {

    @GetMapping("/editarponto")
    public String getEditarPonto(HttpServletRequest request) {
        if (request.getHeader("Referer") != null) {
            return "Pontos/editar";
        } else {
            return "redirect:/";
        }
    }

}

