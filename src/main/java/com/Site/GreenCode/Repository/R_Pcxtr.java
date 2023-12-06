package com.Site.GreenCode.Repository;

import com.Site.GreenCode.Model.M_Pcxtr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface R_Pcxtr extends JpaRepository<M_Pcxtr, Long> {

    }
