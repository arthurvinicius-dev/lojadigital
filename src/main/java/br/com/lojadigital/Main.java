package br.com.lojadigital;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import br.com.lojadigital.entities.Cliente;
import br.com.lojadigital.entities.Produto;
import br.com.lojadigital.services.ClienteService;
import br.com.lojadigital.services.ProdutoService;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância do serviço de cliente
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();

        boolean adicionadop = produtoService.addProduto("Mouse PROx", "Mouse gamer RGB pro", BigDecimal.valueOf(300.00),
        10);

        
        if (adicionadop) {
        System.out.println("Produto adicionado com sucesso!");
        } else {
        System.out.println("Falha ao adicionar produto!");
        }
        
        Optional<Produto> produtoOptional = produtoService.buscaProduto(1);
        if (produtoOptional.isPresent()) {
            Produto produtoEncontrado = produtoOptional.get();
            System.out.println("Produto encontrado: " + produtoEncontrado);
        } else {
            System.out.println("Produto não encontrado.");
        }
        
        boolean removidop = produtoService.removeProduto(1);
        if (removidop) {
            System.out.println("Produto removido.");
        } else {
            System.out.println("Falha ao remover produto! Produto não encontrado.");
        }


        // Adicionando um cliente
        boolean adicionado = clienteService.addCliente("João Davi", LocalDate.of(2003, 5, 2),
                "439.147.970-29", "Rua A, 123", "(88) 994587888", "joao@example.com",
                "Senha123@");
        // OBS. esse CPF foi gerador por um Gerador de CPF .
        // https://www.4devs.com.br/gerador_de_cpf

        if (adicionado) {
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            System.out.println("Falha ao adicionar cliente!");
        }

        // Buscando um cliente pelo ID
        Optional<Cliente> clienteOptional = clienteService.buscaCliente(1);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }

        // Alterando um cliente
        if (clienteService.alteraCliente(1, "João Silva", LocalDate.of(1990, 5, 15),
                "439.147.970-29", "Rua A, 123", "(88) 994587858", "joao@example.com",
                "novaSenha@3")) {
            System.out.println("Cliente alterado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado para alteração.");
        }

        // Removendo um cliente
        if (clienteService.removeCliente(1)) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado para remoção.");
        }
    }
}
