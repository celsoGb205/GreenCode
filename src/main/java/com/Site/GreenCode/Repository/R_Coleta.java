package com.Site.GreenCode.Repository;

import com.Site.GreenCode.Model.M_Coleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Coleta extends JpaRepository<M_Coleta, Long> {
}
