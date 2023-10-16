package com.Site.GreenCode.Repository;


import com.Site.GreenCode.Model.M_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {
        @Query(value = "SELECT * FROM cad_pessoa WHERE email = :email and senha = :senha limit 1",nativeQuery = true)
    M_Pessoa findByEmailESenha(@Param("email") String email, @Param ("senha") String senha);
}

