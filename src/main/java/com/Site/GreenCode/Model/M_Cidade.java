package com.Site.GreenCode.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cidades")
public class M_Cidade {
    @Id
    private Long cod_cidade;
    private String uf;
    private Long cod_uf;
    private String cidade;
    private Long num_hab;

    public Long getCod_cidade() {
        return cod_cidade;
    }

    public void setCod_cidade(Long cod_cidade) {
        this.cod_cidade = cod_cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getCod_uf() {
        return cod_uf;
    }

    public void setCod_uf(Long cod_uf) {
        this.cod_uf = cod_uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(Long num_hab) {
        this.num_hab = num_hab;
    }
}
