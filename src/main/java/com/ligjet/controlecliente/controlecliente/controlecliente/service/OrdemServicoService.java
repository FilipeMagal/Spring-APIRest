package com.ligjet.controlecliente.controlecliente.controlecliente.service;

import com.ligjet.controlecliente.controlecliente.controlecliente.entity.Cliente;
import com.ligjet.controlecliente.controlecliente.controlecliente.entity.OrdemServico;
import org.springframework.stereotype.Service;

import java.util.List;
@Service//Anotação do framework Spring
public interface OrdemServicoService {//Interface para criar as regras da aplicação
    List<OrdemServico> findAllOrdemServico();//Método que deverá ser implementado por outra classe (GET)

    OrdemServico findById (Long id);//Método que deverá ser implementado pelas classes(GET)

    void save (String descricao, String valorOrcamento, boolean aprovado, Cliente cliente);//Método que deverá ser implementado pelas classes (PUT)
    void save (Long id, String descricao, String valorOrcamento, boolean aprovado, Cliente cliente);//Método que deverá ser implementado pelas classes (POST)
    void delete (Long id);//Método que deverá ser implementado pelas classes (DELETE)

}
