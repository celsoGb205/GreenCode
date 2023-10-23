package com.Site.GreenCode.Service;

import com.Site.GreenCode.Model.M_Coleta;
import com.Site.GreenCode.Model.M_Resposta;
import com.Site.GreenCode.Repository.R_Coleta;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;

public class S_Coleta {


    public static R_Coleta r_coleta;

    public S_Coleta(R_Coleta r_coleta) {
        this.r_coleta = r_coleta;
    }

    public static M_Resposta cadastrarPontoDeColeta(String bairro, String rua, String tipo_lixo, LocalDateTime  data_inicial, LocalDateTime  data_final) {
        boolean podeEnviar = true;
        String mensagem = "";

        if (S_Generico.textoEstaVazio(bairro)) {
            podeEnviar = false;
            mensagem += "O bairro precisa ser informado!";
        }
        if (S_Generico.textoEstaVazio(rua)) {
            podeEnviar = false;
            mensagem += "O rua precisa ser preenchido!";
        }
        if (S_Generico.textoEstaVazio(tipo_lixo)) {
            podeEnviar = false;
            mensagem += "O Tipo de lixo precisa ser preenchido!";
        }
        if (S_Generico.textoEstaVazio(String.valueOf(data_inicial))) {
            podeEnviar = false;
            mensagem += "A data e o horario inicial precisa ser preenchido!";
        }
        if (S_Generico.textoEstaVazio(String.valueOf(data_final))) {
            podeEnviar = false;
            mensagem += "A data e o horario final precisa ser preenchido!";
        }
        if (podeEnviar) {
            M_Coleta m_coleta = new M_Coleta();
            m_coleta.setBairro(bairro);
            m_coleta.setRua(rua);
            m_coleta.setTipo_lixo(tipo_lixo);
            m_coleta.setData_inicio(data_inicial);
            m_coleta.setData_final(data_final);

            try {
                r_coleta.save(m_coleta);
                mensagem += "Ponto de Coleta salvo com sucesso";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Falha ao inserir registro do notebook";
            }
        }
        return new M_Resposta(podeEnviar,mensagem);
    }

}


