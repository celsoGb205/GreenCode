package com.Site.GreenCode.Controller;


import com.Site.GreenCode.Service.S_Coleta;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_PontodeColeta {

    @GetMapping("/ponto_coleta")
    public String getPontoColeta(HttpServletRequest request,
                                 HttpSession session,
                                 Model model
    ) {
        if (request.getHeader("Referer") != null) {
            model.addAttribute("pdc", S_Coleta.listarPontosColeta());
            return "Pontos/ponto_coleta";
        } else {
            return "redirect:/";
        }
    }
}