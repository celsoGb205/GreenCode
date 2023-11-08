package com.Site.GreenCode.Service;

import com.Site.GreenCode.Model.M_Cidade;
import com.Site.GreenCode.Repository.R_Cidade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class S_Cidade {
    private static R_Cidade r_cidade;

    public S_Cidade(R_Cidade r_cidade) {
        this.r_cidade = r_cidade;
    }

    public static ArrayList<M_Cidade> getCidades(){
        return r_cidade.listCidades();
    }
}
