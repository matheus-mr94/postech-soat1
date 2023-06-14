package com.padocadev.dominio.porta.cliente;

import com.padocadev.dominio.entidade.cliente.Cliente;

import java.util.Optional;

public interface ClienteRepositorioAdaptadorPorta {
    Cliente criarCliente(Cliente cliente);
    Optional<Cliente> buscaClientePorCpf(String cpf);
    Optional<Cliente> buscaClientePorEmail(String email);
    boolean existeClienteComCpf(String cpf);
    boolean existeClienteComEmail(String email);
}
