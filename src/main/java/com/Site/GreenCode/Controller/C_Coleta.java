package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Model.M_Pessoa;
import com.Site.GreenCode.Model.M_Resposta;
import com.Site.GreenCode.Service.S_Cidade;
import com.Site.GreenCode.Service.S_Coleta;
import com.Site.GreenCode.Service.S_Residuo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import java.time.LocalDateTime;

@Controller
public class C_Coleta {

    @GetMapping("/coleta")
    public String getColeta(HttpServletRequest request, Model model) {
        if (request.getHeader("Referer") != null) {
            model.addAttribute("cidades", S_Cidade.getCidades());
            model.addAttribute("tipo_residuo", S_Residuo.getResiduos());
            return "Cadastro/coleta";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/coleta")
    @ResponseBody
    public M_Resposta postColeta(
            @RequestParam("cidade") String cod_cidade,
            @RequestParam("rua") String rua,
            @RequestParam("bairro") String bairro,
            @RequestParam("numero") String numero,
            @RequestParam("tipo_lixo") String tipo_lixo,
            @RequestParam("data_inicial") LocalDateTime data_inicial,
            @RequestParam("data_final") LocalDateTime data_final,
            HttpSession session) {
        Object usuario = session.getAttribute("email");
        Gson gson = new Gson();
        Long[] tipos_lixo = gson.fromJson(tipo_lixo, Long[].class);

        return S_Coleta.cadastrarPontoDeColeta(cod_cidade, rua, bairro, numero, tipo_lixo, data_inicial, data_final, (M_Pessoa) usuario, tipos_lixo);
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste/teste";
    }
}

