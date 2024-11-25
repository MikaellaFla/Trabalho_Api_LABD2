package com.ApiServicos.ApiServicos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_info")
public class Usuario {

    @Id
    private int IdUsuario; // Alterado para int
    private String LoginUsuario;
    private String SenhaUsuario;
    private String TipoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String loginUsuario, String senhaUsuario, String tipoUsuario) { // Alterado para int
        this.IdUsuario = idUsuario;
        this.LoginUsuario = loginUsuario;
        this.SenhaUsuario = senhaUsuario;
        this.TipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() { // Alterado para int
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) { // Alterado para int
        this.IdUsuario = idUsuario;
    }

    public String getLoginUsuario() {
        return LoginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.LoginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return SenhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.SenhaUsuario = senhaUsuario;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.TipoUsuario = tipoUsuario;
    }
}

