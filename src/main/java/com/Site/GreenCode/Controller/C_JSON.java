package com.Site.GreenCode.Controller;

import com.Site.GreenCode.Model.M_Cidade;
import com.Site.GreenCode.Service.S_Cidade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@ResponseBody
public class C_JSON {
    @GetMapping("/cidades")
    public ArrayList<M_Cidade> getCidades(){
        return S_Cidade.getCidades();
    }

    @PostMapping("/cidades")
    public String PostCidades(Model model) {

        ArrayList<M_Cidade> cidade = S_Cidade.getCidades();

       // model.addAttribute(("resultados"), cidade.get());

        return "Home/home";
    }


}


