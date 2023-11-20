package com.Site.GreenCode.Repository;

import com.Site.GreenCode.Model.M_Coleta;
import com.Site.GreenCode.Model.M_PontosColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface R_Coleta extends JpaRepository<M_Coleta, Long> {
    @Query(value = "SELECT \n" +
            "c.cidade,\n" +
            "p.rua,\n" +
            "p.bairro,\n" +
            "p.numero,\n" +
            "p.tipo_lixo,\n" +
            "p.data_inicio,\n" +
            "p.data_final,\n" +
            "p.usuario_id\n" +
            "FROM ponto_coleta p\n" +
            "INNER JOIN cidades c \n" +
            "ON p.cod_cidade = c.cod_cidade\n" +
            "where current_timestamp between p.data_inicio and p.data_final", nativeQuery = true)
    List<M_PontosColeta> listarCidadesDosPontosColeta();


}