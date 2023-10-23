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
public class C_Coleta {

    @GetMapping("/coleta")
    public String getNotebooks(HttpServletRequest request) {
        if (request.getHeader("Referer") != null) {
            return "Cadastro/coleta";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/coleta")
    @ResponseBody
    public M_Resposta connectNotebooks(@RequestParam("bairro") String bairro,
                                       @RequestParam("rua") String rua,
                                       @RequestParam("tipo_lixo") String tipo_lixo,
                                       @RequestParam("data_inicial")LocalDateTime data_inicial,
                                       @RequestParam("data_final") LocalDateTime data_final) {
        return S_Coleta.cadastrarPontoDeColeta(bairro,rua,tipo_lixo,data_inicial,data_final);
    }
}
