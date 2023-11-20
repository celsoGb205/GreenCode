package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Model.M_Resposta;
import com.Site.GreenCode.Service.S_Email;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Recuperar {


    @GetMapping("/senha")
    public String getLogin(){
        return "Recuperar/senha";
    }

    @PostMapping("/senha")
    @ResponseBody
    public String postSenha(
            @RequestParam("email") String email,
            HttpSession session) {
        return S_Email.sendMail(email);
    }
}

