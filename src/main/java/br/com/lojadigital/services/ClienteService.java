package br.com.lojadigital.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.lojadigital.domain.ClienteServiceInterface;
import br.com.lojadigital.dao.ClienteDAO;
import br.com.lojadigital.entities.Cliente;
import br.com.lojadigital.util.ValidacaoClienteUtil;

public class ClienteService implements ClienteServiceInterface {
    private ClienteDAO clienteDAO;
    private ValidacaoClienteUtil validacaoUtil;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
        this.validacaoUtil = new ValidacaoClienteUtil();
    }

    // Método para adicionar um novo cliente
    @Override
    public boolean addCliente(String nome, LocalDate dataNascimento, String cpf, String endereco, String telefone,
            String email, String senha) {

        try {
            // Verifica se já existe algum cliente com os mesmos atributos
            List<Cliente> clientesAtributosIguais = clienteDAO.getClientes().stream()
                    .filter(cliente -> cliente.getCpf().equals(cpf)
                            || cliente.getTelefone().equals(telefone)
                            || cliente.getEmail().equals(email))
                    .collect(Collectors.toList());

            if (!clientesAtributosIguais.isEmpty()) {
                throw new IllegalArgumentException("Já existe um cliente com os mesmos atributos.");
            }

            validarCampos(nome, dataNascimento, cpf, endereco, telefone, email, senha);
            // Implementação para adicionar um cliente
            Cliente cliente = new Cliente(0, nome, dataNascimento, cpf, endereco, telefone, email, senha);
            clienteDAO.addCliente(cliente);
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para alterar os dados de um cliente existente
    @Override
    public boolean alteraCliente(int id, String nome, LocalDate dataNascimento, String cpf, String endereco,
            String telefone, String email, String senha) {
        // Implementação para alterar um cliente
        Optional<Cliente> clienteOptional = clienteDAO.buscaCliente(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            try {
                validarCampos(nome, dataNascimento, cpf, endereco, telefone, email, senha);

                // Verifica se já existe algum cliente com os mesmos atributos
                List<Cliente> clientesAtributosIguais = clienteDAO.getClientes().stream()
                        .filter(c -> c.getId() != cliente.getId()) // Exclui o cliente atual da lista
                        .filter(c -> c.getCpf().equals(cpf)
                                || c.getTelefone().equals(telefone)
                                || c.getEmail().equals(email))
                        .collect(Collectors.toList());
                if (!clientesAtributosIguais.isEmpty()) {
                    throw new IllegalArgumentException("Já existe um cliente com os mesmos atributos.");
                }

                cliente.setNome(nome);
                cliente.setDataNascimento(dataNascimento);
                cliente.setCpf(cpf);
                cliente.setEndereco(endereco);
                cliente.setTelefone(telefone);
                cliente.setEmail(email);
                cliente.setSenha(senha);
                clienteDAO.alterarCliente(cliente);
                return true; // ou false dependendo da lógica de negócios
            } catch (IllegalArgumentException e) {
                System.err.println("Erro ao alterar cliente: " + e.getMessage());
                return false;
            }
        }
        return false; // ou lançar uma exceção indicando que o cliente não foi encontrado
    }

    // Método para buscar um cliente pelo ID
    @Override
    public Optional<Cliente> buscaCliente(int id) {
        // Implementação para buscar um cliente pelo ID
        return clienteDAO.buscaCliente(id);
    }

    // Método para remover um cliente pelo ID
    @Override
    public boolean removeCliente(int id) {
        // Implementação para remover um cliente pelo ID
        boolean clienteRemovido = clienteDAO.removeCliente(id);
        return clienteRemovido; 
    }

    // Métodos para validar os campos do cliente
    private void validarCampos(String nome, LocalDate dataNascimento, String cpf, String endereco, String telefone,
            String email, String senha) {
        if (nome == null || nome.isEmpty() || !ValidacaoClienteUtil.validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (dataNascimento == null || !ValidacaoClienteUtil.validarIdade(dataNascimento)) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
        if (cpf == null || cpf.isEmpty() || !validacaoUtil.validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço inválido.");
        }
        if (telefone == null || telefone.isEmpty() || !ValidacaoClienteUtil.validarTelefone(telefone)) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        if (email == null || email.isEmpty() || !ValidacaoClienteUtil.validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if (senha == null || senha.isEmpty() || !ValidacaoClienteUtil.validarSenha(senha)) {
            throw new IllegalArgumentException("Senha inválida.");
        }
    }
}
