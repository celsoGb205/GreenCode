package com.Site.GreenCode.Repository;

import com.Site.GreenCode.Model.M_Coleta;
import com.Site.GreenCode.Model.M_MostrarSolicitacao;
import com.Site.GreenCode.Model.M_Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Solicitacao extends JpaRepository<M_Solicitacao, Long> {
    @Query(value="select * from solicitacao", nativeQuery = true)
    M_Solicitacao listCidades();

    @Query(value = "select \n" +
            "\tTO_CHAR(data_entrega, 'HH24:MI') AS hora_minuto_formatado,\n" +
            "\tpc.ponto_id,\n" +
            "\ts.aprovado,\n" +
            "\ts.entregou,\n" +
            "\ts.notificacao,\n" +
            "\ts.respondido,\n" +
            "\ts.id,\n" +
            "\ts.tipo_lixo,\n" +
            "\ts.data_entrega,\n"+
            "\ts.usuario_id,\n"+
            "\tcp.nome as solicitante\n" +
            "from solicitacao s\n" +
            "inner join ponto_coleta pc\n" +
            "\ton pc.ponto_id = s.ponto_id\n" +
            "inner join cad_pessoa cp\n" +
            "\ton s.usuario_id = cp.id\n" +
            "inner join cad_pessoa cpr\n" +
            "\ton pc.usuario_id = cpr.id\t\n" +
            "where pc.usuario_id = :id_usuario"
            +"\n" +
            "\t", nativeQuery = true)
    List<M_MostrarSolicitacao> mostrarSolicitacao(@Param("id_usuario") Long id_usuario);

    @Query(value = "select \n" +
            "\tTO_CHAR(data_entrega, 'HH24:MI') AS hora_minuto_formatado,\n" +
            "\tpc.ponto_id,\n" +
            "\ts.notificacao,\n" +
            "\ts.aprovado,\n" +
            "\ts.entregou,\n" +
            "\ts.respondido,\n" +
            "\ts.tipo_lixo,\n" +
            "\ts.data_entrega,\n" +
            "\tcp.nome as solicitante,\n" +
            "\ts.id,\n" +
            "\ts.qtd,\n"+
            "\ts.usuario_id\n" +
            "from solicitacao s \n" +
            "inner join cad_pessoa cp\n" +
            "on s.usuario_id = cp.id\n" +
            "inner join ponto_coleta pc \n" +
            "on s.ponto_id = pc.ponto_id \n" +
            "where s.usuario_id = :id", nativeQuery = true)
    List<M_Solicitacao> buscarPorId(@Param("id") Long id);

    @Query(value="select * from solicitacao where id = :id", nativeQuery = true)
    M_Solicitacao buscarPorSolicitacaoId(@Param("id") Long id);
}
