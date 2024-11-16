package com.ligjet.controlecliente.controlecliente.controlecliente.service;

import com.ligjet.controlecliente.controlecliente.controlecliente.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Anotação do framework Spring
public interface ClienteService {//Interface para criar as regras da aplicação
    List<Cliente> findAllClientes();//Método que deverá ser implementado por outra classe (GET)

    Cliente findById(Long id);//Método que deverá ser implementado pelas classes(GET)

    void save(Long id, String name, String endereco, Long telefone, String dataCadastro);//Método que deverá ser implementado pelas classes (PUT)
    void save(String name, String endereco, Long telefone, String dataCadastro);//Método que deverá ser implementado pelas classes (POST)
    void delete(Long id);//Método que deverá ser implementado pelas classes (DELETE)
}
