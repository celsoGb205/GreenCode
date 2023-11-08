package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Model.M_Resposta;
import com.Site.GreenCode.Service.S_Pessoa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_AlterarSenha {
    @GetMapping("/alterarsenha")
    public String getAlterarSenha(HttpServletRequest request) {
        if (request.getHeader("Referer") != null) {
            return "Alterar/alterarsenha";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/alterarsenha")
    @ResponseBody
    public M_Resposta postEditUsuario(@RequestParam("senhaAtual") String senhaAtual,
                                      @RequestParam("novaSenha") String novaSenha,
                                      @RequestParam("confSenha") String confSenha,
                                      HttpSession session

    ) {
        return S_Pessoa.updateUsuario(senhaAtual, novaSenha, confSenha,session.getAttribute("email"));
    }
}
