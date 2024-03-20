package br.com.lojadigital.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.lojadigital.domain.ClienteDAOInterface;
import br.com.lojadigital.entities.Cliente;

public class ClienteDAO implements ClienteDAOInterface {

    // Lista para armazenar os clientes
    List<Cliente> listaDeClientes = new ArrayList<>();
    private int proximoId = 1; // Começando com ID 1

    // Método para adicionar um novo cliente
    @Override
    public void addCliente(Cliente cliente) {
        cliente.setId(proximoId); // Define o ID do cliente
        listaDeClientes.add(cliente); // Adiciona o cliente à lista
        proximoId++; // Incrementa o ID para o próximo cliente
    }

    // Método para alterar os dados de um cliente existente
    @Override
    public void alterarCliente(Cliente cliente) {
        for (int i = 0; i < listaDeClientes.size(); i++) {
            if (listaDeClientes.get(i).getId() == cliente.getId()) { // Verifica se o cliente com o ID correspondente
                                                                     // existe
                listaDeClientes.set(i, cliente); // Substitui o cliente na lista com o novo cliente
                return; // Retorna após a alteração
            }
        }
    }

    // Método para buscar um cliente pelo ID
    @Override
    public Optional<Cliente> buscaCliente(int id) {
        return listaDeClientes.stream().filter(cliente -> cliente.getId() == id).findFirst();
        // Retorna um cliente se encontrado, caso contrário, um Optional vazio
    }

    // Método para remover um cliente pelo ID
    @Override
    public void removeCliente(int id) {
        listaDeClientes.removeIf(cliente -> cliente.getId() == id); // Remove o cliente se encontrado na lista
    }

    public List<Cliente> getClientes() {
        return listaDeClientes;
    }
}
