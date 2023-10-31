package com.Site.GreenCode.Repository;

import com.Site.GreenCode.Model.M_Coleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_Coleta extends JpaRepository<M_Coleta, Long> {
    @Query(value = "SELECT * FROM ponto_coleta",nativeQuery = true)
    ArrayList<M_Coleta> listarPontosColeta();



}