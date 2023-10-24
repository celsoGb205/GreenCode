package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Model.M_Resposta;
import com.Site.GreenCode.Service.S_Coleta;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
@Controller
public class C_PontodeColeta {

    @GetMapping("/pontoColeta")
    public String getPontoColeta(HttpServletRequest request) {
        if (request.getHeader("Referer") != null) {
            return "Pontos/ponto_coleta";
        } else {
            return "redirect:/";
        }
    }
}

