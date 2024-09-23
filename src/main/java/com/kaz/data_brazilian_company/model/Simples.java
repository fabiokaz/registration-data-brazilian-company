package com.kaz.data_brazilian_company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
public class Simples {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public boolean optante;
    public String data_opcao;
    public String data_exclusao;
    public String ultima_atualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOptante() {
        return optante;
    }

    public void setOptante(boolean optante) {
        this.optante = optante;
    }

    public String getData_opcao() {
        return data_opcao;
    }

    public void setData_opcao(String data_opcao) {
        this.data_opcao = data_opcao;
    }

    public String getData_exclusao() {
        return data_exclusao;
    }

    public void setData_exclusao(String data_exclusao) {
        this.data_exclusao = data_exclusao;
    }

    public String getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(String ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Simples.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("optante=" + optante)
                .add("data_opcao=" + data_opcao)
                .add("data_exclusao=" + data_exclusao)
                .add("ultima_atualizacao=" + ultima_atualizacao)
                .toString();
    }
}
