package com.Site.GreenCode.Service;

import com.Site.GreenCode.Model.*;
import com.Site.GreenCode.Repository.R_Solicitacao;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class S_Solicitacao {
    private static R_Solicitacao r_solicitacao;

    public S_Solicitacao(R_Solicitacao r_solicitacao) {
        this.r_solicitacao = r_solicitacao;
    }

    public static M_Resposta SolicitarPonto(Long ponto_id, String tipo_lixo, int qtd, LocalDateTime data_entrega, M_Pessoa usuario){
        boolean podeEnviar = true;
        String mensagem = "";

        if (S_Generico.textoEstaVazio(tipo_lixo)) {
            mensagem += "O Tipo de lixo precisa ser preenchido\n";
            podeEnviar = false;
        }
        if (S_Generico.textoEstaVazio(String.valueOf(qtd))){
            mensagem += "O Quantidade precisa ser preenchido\n";
            podeEnviar = false;
        }
        if (S_Generico.textoEstaVazio(String.valueOf(data_entrega))){
            mensagem += "O Data de Entrega precisa ser preenchido\n";
            podeEnviar = false;
        }

        if (podeEnviar) {
            M_Solicitacao m_solicitacao = new M_Solicitacao();
            m_solicitacao.setPonto_id(ponto_id);
            m_solicitacao.setTipo_lixo(tipo_lixo);
            m_solicitacao.setUsuario_id(usuario.getId());
            m_solicitacao.setQtd(qtd);
            m_solicitacao.setData_entrega(data_entrega);
            try {
                r_solicitacao.save(m_solicitacao);
                mensagem += "Solicitação efetuado com sucesso";
            } catch (DataIntegrityViolationException e) {
                    mensagem += "Erro ao mandar Solicitação";
                podeEnviar = false;
            }

        }
        M_Resposta m_resposta = new M_Resposta(podeEnviar, mensagem);
        return m_resposta;

    }
    public static List<M_MostrarSolicitacao> mostrarSolicitacao(M_Pessoa usuario) {
        return r_solicitacao.mostrarSolicitacao(usuario.getId());
    }

    public static List<M_Solicitacao> mostrarSolicitacaop(M_Pessoa usuario) {
        return r_solicitacao.buscarPorId(usuario.getId());
    }

    public static M_Solicitacao aceitarRequisicao(String id) {
        M_Solicitacao m_solicitacao = (M_Solicitacao) r_solicitacao.buscarPorSolicitacaoId(Long.parseLong(id));
        m_solicitacao.setRespondido(true);
        m_solicitacao.setAprovado(true);
        r_solicitacao.save(m_solicitacao);
        return  m_solicitacao;
    }

    public static M_Solicitacao recusarRequisicao(String id) {
        M_Solicitacao m_solicitacao = (M_Solicitacao) r_solicitacao.buscarPorSolicitacaoId(Long.parseLong(id));
        m_solicitacao.setRespondido(true);
        m_solicitacao.setAprovado(false);
        r_solicitacao.save(m_solicitacao);
        return  m_solicitacao;
    }

    public static M_Solicitacao aceitarEntrega(String id) {
        M_Solicitacao m_solicitacao = (M_Solicitacao) r_solicitacao.buscarPorSolicitacaoId(Long.parseLong(id));
        m_solicitacao.setEntregou(true);
        r_solicitacao.save(m_solicitacao);
        return  m_solicitacao;
    }

    public static M_Solicitacao fecharNotificacao(String id) {
        M_Solicitacao m_solicitacao = (M_Solicitacao) r_solicitacao.buscarPorSolicitacaoId(Long.parseLong(id));
        m_solicitacao.setNotificacao(true);
        r_solicitacao.save(m_solicitacao);
        return  m_solicitacao;
    }
}


