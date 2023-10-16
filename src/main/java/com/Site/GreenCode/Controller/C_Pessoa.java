package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Model.M_Pessoa;
import com.Site.GreenCode.Model.M_Resposta;
import com.Site.GreenCode.Service.S_Pessoa;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class C_Pessoa {
    @GetMapping("/")
    public String getLogin(){
        return "Login/login";
    }

    @PostMapping("/")
    @ResponseBody
    public M_Resposta postLogin(@RequestParam("email") String email,
                            @RequestParam("senha") String senha, HttpSession session,
                            RedirectAttributes redirectAttributes) {
        M_Pessoa pessoa = S_Pessoa.getPessoaLogin(email, senha);
        session.setAttribute("email", S_Pessoa.getPessoaLogin(email, senha));
        if (session.getAttribute("email") == null) {
            M_Resposta m_resposta = new M_Resposta(false,"E-mail ou senha inválidos!");
            return m_resposta;
        } else {
            M_Resposta m_resposta = new M_Resposta(true,"Bem Vindo!");
            return m_resposta;
        }

    }

    @ModelAttribute("email")
    public M_Pessoa getUsuario(HttpSession session) {
        return (M_Pessoa) session.getAttribute("email");
    }


    @GetMapping("/cadastro")
    public String getCadastro(){
        return "Pessoa/cadastro";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public M_Resposta postCadastro(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefone") String telefone,
                                   @RequestParam("senha") String senha
                                  ) {
        return  S_Pessoa.validaCadastro(nome, email, telefone, senha);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("email", null);
        return "redirect:/";
    }
}


