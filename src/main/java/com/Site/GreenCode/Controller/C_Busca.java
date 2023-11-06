package com.Site.GreenCode.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class C_Busca {

    @GetMapping("/busca")
    public String getBusca(HttpServletRequest request) {
        if (request.getHeader("Referer") != null) {
            return "Search/busca";
        } else {
            return "redirect:/";
        }
    }

}
