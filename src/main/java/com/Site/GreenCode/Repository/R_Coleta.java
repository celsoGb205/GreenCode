package com.Site.GreenCode.Repository;

import com.Site.GreenCode.Model.M_Coleta;
import com.Site.GreenCode.Model.M_PontosColeta;
import jakarta.persistence.JoinColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Coleta extends JpaRepository<M_Coleta, Long> {
    @Query(value = "SELECT \n" +
                    "c.cidade, \n" +
                    "p.rua, \n" +
                    "p.bairro, \n" +
                    "p.numero, \n" +
                    "STRING_AGG(tr.nome, ', ' ORDER BY tr.nome) AS tipo_lixo, \n" +
                    "p.data_inicio, \n" +
                    "p.data_final, \n" +
                    "p.usuario_id, \n" +
                    "p.ponto_id, \n" +
                    "p.ativo \n" +
                    "FROM ponto_coleta p \n" +
                    "INNER JOIN cidades c ON p.cod_cidade = c.cod_cidade \n" +
                    "INNER JOIN pcxtr pcxtr ON p.ponto_id = pcxtr.id_pc \n" +
                    "INNER JOIN tipo_residuo tr ON pcxtr.id_tr = tr.id \n" +
                    "WHERE current_timestamp BETWEEN p.data_inicio AND p.data_final \n" +
                    "GROUP BY c.cidade, p.rua, p.bairro, p.numero, p.data_inicio, p.data_final, p.usuario_id, p.ponto_id, p.ativo", nativeQuery = true)
    List<M_PontosColeta> listarCidadesDosPontosColeta();

    @Query(value = "select * from ponto_coleta where ponto_id = :id", nativeQuery = true)
    M_Coleta buscarPorId(@Param("id") Long id);

   
}
