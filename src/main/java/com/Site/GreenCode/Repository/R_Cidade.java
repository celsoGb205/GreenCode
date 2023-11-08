package com.Site.GreenCode.Repository;

import com.Site.GreenCode.Model.M_Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_Cidade extends JpaRepository<M_Cidade, Long> {
    @Query(value="select cod_cidade, cidade||' - '||uf as cidade \n" +
            "from cidades\n" +
            "order by cidade", nativeQuery = true)
    ArrayList<M_Cidade> listCidades();
}
