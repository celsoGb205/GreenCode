package com.Site.GreenCode.Model;

import java.time.LocalDateTime;


public interface M_PontosColeta {

    String getCidade();
    String getRua();
    String getBairro();
    int getNumero();
    String getTipo_lixo();
    LocalDateTime getData_inicio();
    LocalDateTime getData_final();
    Long getUsuario_id();

}
