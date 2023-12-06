package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Model.M_Coleta;
import com.Site.GreenCode.Model.M_Pessoa;
import com.Site.GreenCode.Model.M_Resposta;
import com.Site.GreenCode.Service.S_Coleta;
import com.Site.GreenCode.Service.S_Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

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

    @PostMapping("/solicitacaoP")
    @ResponseBody
    public M_Resposta MandarSolicitacao(@RequestParam("ponto_id") Long ponto_id,
                                        @RequestParam("tipo_lixo") String tipo_lixo,
                                        @RequestParam("qtd") int qtd,
                                        @RequestParam("data_entrega") LocalDateTime data_entrega,
                                        HttpSession session,
                                        Model model){
        M_Pessoa usuario = (M_Pessoa) session.getAttribute("email");
        return S_Solicitacao.SolicitarPonto(ponto_id, tipo_lixo, qtd,data_entrega,usuario);
    }
    @PostMapping("/deletar")
    @ResponseBody
    public M_Coleta deletarPonto(@RequestParam("id") String id){
        return S_Coleta.ExcluirPonto(id);

    }
}
