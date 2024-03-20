package br.com.lojadigital.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Cliente {

    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
    private BigDecimal saldo;

    // Construtor da classe Cliente
    public Cliente(int id, String nome, LocalDate dataNascimento, String cpf, String endereco, String telefone,
            String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.saldo = BigDecimal.valueOf(100.00); // Saldo inicializado com 100.00
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    // Método equals para comparar se dois objetos Cliente são iguais
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Verifica se é o mesmo objeto
            return true;
        if (obj == null || getClass() != obj.getClass()) // Verifica se o objeto é nulo ou se não é uma instância de
                                                         // Cliente
            return false;
        Cliente cliente = (Cliente) obj;
        // Compara os atributos dos objetos para determinar se são iguais
        return id == cliente.id &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(dataNascimento, cliente.dataNascimento) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(endereco, cliente.endereco) &&
                Objects.equals(telefone, cliente.telefone) &&
                Objects.equals(email, cliente.email) &&
                Objects.equals(senha, cliente.senha) &&
                Objects.equals(saldo, cliente.saldo);
    }

    // Método hashCode para gerar um código hash para o objeto Cliente
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, cpf, endereco, telefone, email, senha, saldo);
    }

    // Método toString para retornar uma representação em string do objeto Cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
