package com.ApiServicos.ApiServicos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_info")
public class Usuario {

    @Id
    private String IdUsuario;
    private String LoginUsuario;
    private String SenhaUsuario;
    private String TipoUsuario;

    public Usuario() {
    }

    public Usuario(String idUsuario, String loginUsuario, String senhaUsuario, String tipoUsuario) {
        this.IdUsuario = idUsuario;
        this.LoginUsuario = loginUsuario;
        this.SenhaUsuario = senhaUsuario;
        this.TipoUsuario = tipoUsuario;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
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
