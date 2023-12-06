package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Model.M_Pessoa;
import com.Site.GreenCode.Model.M_Solicitacao;
import com.Site.GreenCode.Service.S_Solicitacao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class C_Home {

    @GetMapping("/home")
    public String getHome(HttpSession session,
                          Model model) {
        if (session.getAttribute("email") != null) {
            model.addAttribute("email", session.getAttribute("email"));
            model.addAttribute("slc", S_Solicitacao.mostrarSolicitacao((M_Pessoa) session.getAttribute("email")));
            model.addAttribute("slcp", S_Solicitacao.mostrarSolicitacaop((M_Pessoa) session.getAttribute("email")));
            return "home/home";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/Home")
    public String getPartialHome(HttpServletRequest request,
                                 HttpSession session,
                                 Model model){
        if(request.getHeader("Referer") != null) {
            model.addAttribute("email", session.getAttribute("email"));
            model.addAttribute("slc", S_Solicitacao.mostrarSolicitacao((M_Pessoa) session.getAttribute("email")));
            model.addAttribute("slcp", S_Solicitacao.mostrarSolicitacaop((M_Pessoa) session.getAttribute("email")));
            return "home/partial_home";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/aceitar")
    @ResponseBody
    public M_Solicitacao aceitarRequisicao(@RequestParam("id") String id){
        return S_Solicitacao.aceitarRequisicao(id);

    }

    @PostMapping("/recusar")
    @ResponseBody
    public M_Solicitacao recusarRequisicao(@RequestParam("id") String id){
        return S_Solicitacao.recusarRequisicao(id);

    }

    @PostMapping("/entrega")
    @ResponseBody
    public M_Solicitacao aceitarEntrega(@RequestParam("id") String id){
        return S_Solicitacao.aceitarEntrega(id);

    }

    @PostMapping("/notificacao")
    @ResponseBody
    public M_Solicitacao fecharNotificacao(@RequestParam("id") String id){
        return S_Solicitacao.fecharNotificacao(id);

    }
}

