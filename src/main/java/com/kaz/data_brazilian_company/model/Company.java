package com.kaz.data_brazilian_company.model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String status;
    public LocalDateTime ultima_atualizacao;
    @Column(nullable = false, unique = true)
    public String cnpj;
    public String tipo;
    public String porte;
    public String nome;
    public String fantasia;
    public String abertura;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "company_main_activities",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Atividade> atividade_principal;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "company_secondary_activities",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Atividade> atividades_secundarias;

    public String natureza_juridica;
    public String logradouro;
    public String numero;
    public String complemento;
    public String cep;
    public String bairro;
    public String municipio;
    public String uf;
    public String email;
    public String telefone;
    public String efr;
    public String situacao;
    public String data_situacao;
    public String motivo_situacao;
    public String situacao_especial;
    public String data_situacao_especial;
    public String capital_social;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Qsa> qsa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "simples_id")
    private Simples simples;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "simei_id")
    private Simei simei;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_id")
    private Billing billing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(LocalDateTime ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getAbertura() {
        return abertura;
    }

    public void setAbertura(String abertura) {
        this.abertura = abertura;
    }

    public List<Atividade> getAtividade_principal() {
        return atividade_principal;
    }

    public void setAtividade_principal(List<Atividade> atividade_principal) {
        this.atividade_principal = atividade_principal;
    }

    public List<Atividade> getAtividades_secundarias() {
        return atividades_secundarias;
    }

    public void setAtividades_secundarias(List<Atividade> atividades_secundarias) {
        this.atividades_secundarias = atividades_secundarias;
    }

    public String getNatureza_juridica() {
        return natureza_juridica;
    }

    public void setNatureza_juridica(String natureza_juridica) {
        this.natureza_juridica = natureza_juridica;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEfr() {
        return efr;
    }

    public void setEfr(String efr) {
        this.efr = efr;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getData_situacao() {
        return data_situacao;
    }

    public void setData_situacao(String data_situacao) {
        this.data_situacao = data_situacao;
    }

    public String getMotivo_situacao() {
        return motivo_situacao;
    }

    public void setMotivo_situacao(String motivo_situacao) {
        this.motivo_situacao = motivo_situacao;
    }

    public String getSituacao_especial() {
        return situacao_especial;
    }

    public void setSituacao_especial(String situacao_especial) {
        this.situacao_especial = situacao_especial;
    }

    public String getData_situacao_especial() {
        return data_situacao_especial;
    }

    public void setData_situacao_especial(String data_situacao_especial) {
        this.data_situacao_especial = data_situacao_especial;
    }

    public String getCapital_social() {
        return capital_social;
    }

    public void setCapital_social(String capital_social) {
        this.capital_social = capital_social;
    }

    public List<Qsa> getQsa() {
        return qsa;
    }

    public void setQsa(ArrayList<Qsa> qsa) {
        this.qsa = qsa;
    }

    public Simples getSimples() {
        return simples;
    }

    public void setSimples(Simples simples) {
        this.simples = simples;
    }

    public Simei getSimei() {
        return simei;
    }

    public void setSimei(Simei simei) {
        this.simei = simei;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Company.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("status='" + status + "'")
                .add("ultima_atualizacao=" + ultima_atualizacao)
                .add("cnpj='" + cnpj + "'")
                .add("tipo='" + tipo + "'")
                .add("porte='" + porte + "'")
                .add("nome='" + nome + "'")
                .add("fantasia='" + fantasia + "'")
                .add("abertura='" + abertura + "'")
                .add("atividade_principal=" + atividade_principal)
                .add("atividades_secundarias=" + atividades_secundarias)
                .add("natureza_juridica='" + natureza_juridica + "'")
                .add("logradouro='" + logradouro + "'")
                .add("numero='" + numero + "'")
                .add("complemento='" + complemento + "'")
                .add("cep='" + cep + "'")
                .add("bairro='" + bairro + "'")
                .add("municipio='" + municipio + "'")
                .add("uf='" + uf + "'")
                .add("email='" + email + "'")
                .add("telefone='" + telefone + "'")
                .add("efr='" + efr + "'")
                .add("situacao='" + situacao + "'")
                .add("data_situacao='" + data_situacao + "'")
                .add("motivo_situacao='" + motivo_situacao + "'")
                .add("situacao_especial='" + situacao_especial + "'")
                .add("data_situacao_especial='" + data_situacao_especial + "'")
                .add("capital_social='" + capital_social + "'")
                .add("qsa=" + qsa)
                .add("simples=" + simples)
                .add("simei=" + simei)
                .add("billing=" + billing)
                .toString();
    }
}
