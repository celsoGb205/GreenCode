package com.Site.GreenCode.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface M_MostrarSolicitacao {

    Long getPonto_id();
    String getTipo_lixo();
    String getSolicitante();
    LocalDateTime getData_entrega();
    Long getId();
    Boolean getRespondido();
    Boolean getAprovado();
    String getHora_minuto_formatado();
    Boolean getEntregou();
    Boolean getNotificacao();
    Long getUsuario_id();
}
