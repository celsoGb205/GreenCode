package com.Site.GreenCode.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="solicitacao")
public class M_Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ponto_id;
    private Long usuario_id;
    private String tipo_lixo;
    private int qtd;
    private LocalDateTime data_entrega;
    private boolean respondido;
    private boolean aprovado;
    private boolean entregou;
    private boolean notificacao;

    public LocalDateTime getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(LocalDateTime data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getTipo_lixo() {
        return tipo_lixo;
    }

    public void setTipo_lixo(String tipo_lixo) {
        this.tipo_lixo = tipo_lixo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPonto_id() {
        return ponto_id;
    }

    public void setPonto_id(Long ponto_id) {
        this.ponto_id = ponto_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long id) {
        this.usuario_id = id;
    }

    public boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public boolean getRespondido() {
        return respondido;
    }

    public void setRespondido(boolean respondido) {
        this.respondido = respondido;
    }

    public boolean getEntregou() {
        return entregou;
    }

    public void setEntregou(boolean entregou) {
        this.entregou = entregou;
    }

    public boolean getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(boolean notificacao) {
        this.notificacao = notificacao;
    }
}
