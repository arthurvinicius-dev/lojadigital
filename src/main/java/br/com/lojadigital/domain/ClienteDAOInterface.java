package br.com.lojadigital.domain;

import java.util.Optional;

import br.com.lojadigital.entities.Cliente;

public interface ClienteDAOInterface {

    // Interface para o acesso aos dados dos clientes (DAO - Data Access Object)

    void addCliente(Cliente cliente); // Adicionar Cliente

    void alterarCliente(Cliente cliente);// Alterar Cliente

    Optional<Cliente> buscaCliente(int id);// Busca Cliente

    void removeCliente(int id);// Remove Cliente
}
