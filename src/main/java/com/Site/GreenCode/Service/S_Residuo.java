package com.Site.GreenCode.Service;

import com.Site.GreenCode.Model.M_Residuo;
import com.Site.GreenCode.Repository.R_Cidade;
import com.Site.GreenCode.Repository.R_Residuo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class S_Residuo {
    private static R_Residuo r_residuo;

    public S_Residuo(R_Residuo r_residuo) {
        this.r_residuo = r_residuo;
    }

    public static ArrayList<M_Residuo> getResiduos(){
        return r_residuo.listLixo();
    }
}