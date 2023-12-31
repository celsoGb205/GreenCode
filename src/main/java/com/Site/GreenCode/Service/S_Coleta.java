package com.Site.GreenCode.Service;

import com.Site.GreenCode.Model.*;
import com.Site.GreenCode.Repository.R_Coleta;
import com.Site.GreenCode.Repository.R_Pcxtr;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class S_Coleta {

    public static R_Coleta r_coleta;
    public static R_Pcxtr r_pcxtr;

    public S_Coleta(R_Coleta r_coleta, R_Pcxtr r_pcxtr) {
        this.r_coleta = r_coleta;
        this.r_pcxtr = r_pcxtr;
    }

    public static M_Resposta cadastrarPontoDeColeta(String cod_cidade, String rua, String bairro, String numero, String tipo_lixo, LocalDateTime  data_inicial, LocalDateTime  data_final, M_Pessoa usuario, Long[] tipos_lixo) {
        boolean podeEnviar = true;
        String mensagem = "";

        if (S_Generico.textoEstaVazio(String.valueOf(cod_cidade))) {
            podeEnviar = false;
            mensagem += "O cidade precisa ser preenchido!";
        }

        if (S_Generico.textoEstaVazio(rua)) {
            podeEnviar = false;
            mensagem += "O rua precisa ser preenchido!";
        }
        if (S_Generico.textoEstaVazio(bairro)) {
            podeEnviar = false;
            mensagem += "O bairro precisa ser informado!";
        }
        if (S_Generico.textoEstaVazio(String.valueOf(numero))) {
            podeEnviar = false;
            mensagem += "O bairro precisa ser informado!";
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
            m_coleta.setCidade(Long.valueOf(cod_cidade));
            m_coleta.setRua(rua);
            m_coleta.setBairro(bairro);
            m_coleta.setNumero(Integer.parseInt(numero));
            m_coleta.setData_inicio(data_inicial);
            m_coleta.setData_final(data_final);
            m_coleta.setUsuario_id(usuario.getId());
            m_coleta.setAtivo(true);

            try {
                m_coleta = r_coleta.save(m_coleta);

                for (Long aLong : tipos_lixo) {
                    M_Pcxtr m_pcxtr = new M_Pcxtr();
                    m_pcxtr.setId_pc(m_coleta.getPonto_id());
                    m_pcxtr.setId_tr(aLong);
                    m_pcxtr = r_pcxtr.save(m_pcxtr);
                }
                mensagem += "Ponto de Coleta salvo com sucesso";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Falha ao inserir registro do notebook";
            }


        }
        return new M_Resposta(podeEnviar,mensagem);
    }

    public static M_Coleta EditarPonto(String id){
        M_Coleta m_coleta = r_coleta.buscarPorId(Long.parseLong(id));
        return m_coleta;
    }
    public static M_Coleta ExcluirPonto(String id) {
        M_Coleta m_coleta = r_coleta.buscarPorId(Long.parseLong(id));
        m_coleta.setAtivo(false);
        r_coleta.save(m_coleta);
        return m_coleta;
    }


    public static List<M_PontosColeta> listarPontosColeta() {
        return r_coleta.listarCidadesDosPontosColeta();
    }
    }
