package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Service.S_Cidade;
import com.Site.GreenCode.Service.S_Coleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class C_PontodeColeta {

    private final S_Coleta s_coleta;

    @Autowired
    public C_PontodeColeta(S_Coleta s_coleta) {
        this.s_coleta = s_coleta;
    }

    @GetMapping("/ponto_coleta")
    public String getPontoColeta(HttpServletRequest request,
                                 HttpSession session,
                                 Model model) {
        if (request.getHeader("Referer") != null) {
            model.addAttribute("email", session.getAttribute("email"));
            model.addAttribute("pdc", S_Coleta.listarPontosColeta());
            return "Pontos/ponto_coleta";
        } else {
            return "redirect:/";
        }
    }
}
