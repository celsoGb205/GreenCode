package com.Site.GreenCode.Repository;


import com.Site.GreenCode.Model.M_Pessoa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {
        @Query(value = "SELECT * FROM cad_pessoa WHERE email = :email and senha = :senha limit 1",nativeQuery = true)
    M_Pessoa findByEmailESenha(@Param("email") String email, @Param ("senha") String senha);

    @Modifying
    @Transactional
    @Query("UPDATE M_Pessoa u SET u.senha = :senha where u.id = :id")
    void atualizaSenhaUsuarioPorId(@Param("senha") String senha,@Param("id") Long id);
}


