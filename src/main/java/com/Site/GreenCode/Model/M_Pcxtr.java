package com.Site.GreenCode.Model;

import jakarta.persistence.*;

@Entity
@Table(name="pcxtr")
public class M_Pcxtr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long id_pc;
    private Long id_tr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_pc() {
        return id_pc;
    }

    public void setId_pc(Long id_pc) {
        this.id_pc = id_pc;
    }

    public Long getId_tr() {
        return id_tr;
    }

    public void setId_tr(Long id_tr) {
        this.id_tr = id_tr;
    }
}
