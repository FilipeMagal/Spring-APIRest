package com.ligjet.controlecliente.controlecliente.controlecliente.service.impl;

import com.ligjet.controlecliente.controlecliente.controlecliente.entity.Cliente;
import com.ligjet.controlecliente.controlecliente.controlecliente.service.ClienteService;
import com.ligjet.controlecliente.controlecliente.controlecliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//Anotação do framework Spring
public class ClienteServiceImpl implements ClienteService { //implements é usado para justamente implementar interfaces

    //Essa classe será usada para lidar com operações de persistência no banco de dados relacional

    @Autowired//A injeção de dependencia fazendo com que o service seja dependente do repository para implementar os dados
    private ClienteRepository clienteRepository;

    public List<Cliente> findAllClientes() {//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET
        return clienteRepository.findAll();//Esse "findAll();" é graças ao Spring Data que já fornece o método
    }

    public Cliente findById(Long id){//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET (pelo ID)
        Optional<Cliente> cl = clienteRepository.findById(id);//Esse "findById();" é graças ao Spring Data que já fornece o método
        return cl.get();
    }

    public void save(Long id, String name, String endereco, Long telefone, String dataCadastro) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como PUT (Por conta do ID)
        Cliente cliente;

        if (id != null) {// Verifica se o ID está presente para decidir entre criar um novo cliente ou atualizar um existente
            cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));// Busca o cliente existente pelo ID, se ele existir
        } else {// Caso não tenha ID, cria um novo cliente
            throw new RuntimeException("Cliente não encontrado com ID: null");
        }
        // Atualiza os dados do cliente
        cliente.setName(name);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        cliente.setDataCadastro(dataCadastro);

        // Salva o cliente no banco de dados
        clienteRepository.save(cliente);//Esse "save" é graças ao Spring Data que já fornece o método
    }

    @Override //Sobrescreve o método pois tem o mesmo nome, mas com os parâmetros diferentes
    public void save(String name, String endereco, Long telefone, String dataCadastro) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como POST
        Cliente cliente = new Cliente();

        // Define os dados do cliente
        cliente.setName(name);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        cliente.setDataCadastro(dataCadastro);

        // Salva o cliente no banco de dados
        clienteRepository.save(cliente);//Esse "save" é graças ao Spring Data que já fornece o método
    }


    public void delete(Long id){//esse "delete" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como DELETE
        Cliente cliente = new Cliente();
        clienteRepository.deleteById(id);//Esse "deleteById();" é graças ao Spring Data que já fornece o método
    }
}

