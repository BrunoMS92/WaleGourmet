package br.com.wale.walegourmet.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 50, unique = true)
    private Date dataRegistro;

    @Column(nullable = false)
    private String user;

    @Column(length = 45, nullable = false, unique = true)
    private String senha;

    // Construtores, getters e setters

    public Usuario() {
    }

    public Usuario(String name, String email, Date dataRegistro, String user, String senha) {
        this.name = name;
        this.email = email;
        this.dataRegistro = dataRegistro;
        this.user = user;
        this.senha = senha;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdm() {
        return senha.contains("%adm%123");
  
    }
    
}
