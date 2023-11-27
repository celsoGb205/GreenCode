package com.Site.GreenCode.Repository;


import com.Site.GreenCode.Model.M_Cidade;
import com.Site.GreenCode.Model.M_Residuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface R_Residuo extends JpaRepository<M_Residuo, Long> {

    @Query(value="select * from tipo_residuo", nativeQuery = true)
    ArrayList<M_Residuo> listLixo();
    }