package br.com.wale.walegourmet.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "receitas")
public class Receita {
    @Id
    private Long id;
    @Column(length = 30, nullable = false, unique = true)
    public String criador;
    @Column(length = 40, nullable = false)
    public String url;
    @Column(length = 255, nullable = false)
    public String foto;
    @Column(length= 90, nullable = false)
    public Date dataRegistro;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCriador() {
        return criador;
    }
    public void setCriador(String criador) {
        this.criador = criador;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public Date getDataRegistro() {
        return dataRegistro;
    }
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }    
    }

