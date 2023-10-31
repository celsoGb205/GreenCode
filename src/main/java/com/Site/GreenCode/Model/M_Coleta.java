package com.Site.GreenCode.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="ponto_coleta")
public class M_Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ponto_id;
    private String cidade;
    private String rua;
    private String bairro;
    private String tipo_lixo;
    private int numero;
    private LocalDateTime data_inicio;
    private LocalDateTime data_final;

    public Long getPonto_id() {
        return ponto_id;
    }

    public void setPonto_id(Long ponto_id) {
        this.ponto_id = ponto_id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTipo_lixo() {
        return tipo_lixo;
    }

    public void setTipo_lixo(String tipo_lixo) {
        this.tipo_lixo = tipo_lixo;
    }

    public LocalDateTime getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDateTime data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDateTime getData_final() {
        return data_final;
    }

    public void setData_final(LocalDateTime data_final) {
        this.data_final = data_final;
    }
}