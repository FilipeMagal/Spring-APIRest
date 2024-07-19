package com.ligjet.controlecliente.controlecliente.controller;

import com.ligjet.controlecliente.controlecliente.entity.Cliente;
import com.ligjet.controlecliente.controlecliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Anotação do framework Spring dizendo que é aqui a classe que será utilizada os principios de uma API REST
@RequestMapping("/ligjet/cliente") //Endpoint padrão da aplicação do Cliente
public class ClienteController {
    @Autowired // Injeção de dependencia, significando que o controller e o service dependem um do outro (para ultilizar os métodos imposto)
    private ClienteService clienteService;

    @GetMapping("/clientes")//Utilizando o protocolo http do API REST para realizar operações como o GET (mostrar dados)
    public List<Cliente> findAllClientes(){
        return clienteService.findAllClientes();//função feita no service para mostrar todos os clientes;
    }

    @GetMapping(value = "/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o GET (mostrar dados)
    public ResponseEntity <Cliente> findById(@PathVariable Long id){ //Anotação do framework Spring
        Cliente obj = clienteService.findById(id); //função feita no service para localizar o id;
        return ResponseEntity.ok().body(obj);//função do framework
    }

    @PostMapping("/create")//Utilizando o protocolo http do API REST para realizar operações como o POST (incluir dados)
    public void createCliente(@RequestBody Cliente cliente) {//Anotação do framework Spring
        clienteService.save(cliente.getName(), cliente.getEndereco(), cliente.getTelefone(), cliente.getDataCadastro());//função feita no service para salvar os dados;
    }

    @PutMapping("/create/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o PUT (alterar dados)
    public void putCliente(@RequestBody Cliente cliente, @PathVariable Long id) {//Anotações do framework Spring
        clienteService.save(id, cliente.getName(), cliente.getEndereco(), cliente.getTelefone(), cliente.getDataCadastro());//função feita no service para salvar os dados (em cima dos dados  que já foram salvos);
    }

    @DeleteMapping("/delete/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o DELETE (excluir dados)
    public void  delete(@PathVariable Long id) {//Anotação do framework Spring
        clienteService.delete(id);//função feita no service para deletar os dados
    }
}