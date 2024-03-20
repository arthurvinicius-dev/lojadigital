package br.com.lojadigital.domain;

import java.time.LocalDate;
import java.util.Optional;

import br.com.lojadigital.entities.Cliente;

public interface ClienteServiceInterface {

        // Interface para o serviço relacionado aos clientes
        boolean addCliente(String nome, LocalDate dataNascimento, String cpf, String endereco, String telefone,
                        String email, String senha);

        boolean alteraCliente(int id, String nome, LocalDate dataNascimento, String cpf, String endereco,
                        String telefone,
                        String email, String senha);

        Optional<Cliente> buscaCliente(int id);

        boolean removeCliente(int id);
}
