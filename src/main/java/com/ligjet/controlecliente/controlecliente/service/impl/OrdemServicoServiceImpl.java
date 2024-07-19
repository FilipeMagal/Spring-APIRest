package com.ligjet.controlecliente.controlecliente.service.impl;

import com.ligjet.controlecliente.controlecliente.entity.Cliente;
import com.ligjet.controlecliente.controlecliente.entity.OrdemServico;
import com.ligjet.controlecliente.controlecliente.repository.OrdemServicoRepository;
import com.ligjet.controlecliente.controlecliente.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service//Anotação do framework Spring
public class OrdemServicoServiceImpl implements OrdemServicoService {

    //Essa classe será usada para lidar com operações de persistência no banco de dados relacional

    @Autowired//A injeção de dependencia fazendo com que o service seja dependente do repository para implementar os dados
    private OrdemServicoRepository ordemServicoRepository;

    public List<OrdemServico> findAllOrdemServico() {//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET
        return ordemServicoRepository.findAll();//Esse "findAll();" é graças ao Spring Data que já fornece o método
    }

    public OrdemServico findById(Long id){//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET (pelo ID)
        Optional <OrdemServico> OS = ordemServicoRepository.findById(id);//Esse "findById();" é graças ao Spring Data que já fornece o método
        return OS.get();
    }

    @Override//Sobrescreve o método pois tem o mesmo nome, mas com os parâmetros diferentes
    public void save(String descricao, String valorOrcamento, boolean aprovado, Cliente cliente) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como POST
        OrdemServico ordemServico = new OrdemServico();

        // Define os dados do cliente
        ordemServico.setDescricao(descricao);
        ordemServico.setValorOrcamento(valorOrcamento);
        ordemServico.setAprovado(aprovado);
        ordemServico.setCliente(cliente);
        ordemServico.setDataInicio(LocalDateTime.now());

        // Salva o cliente no banco de dados
        ordemServicoRepository.save(ordemServico);//Esse "save" é graças ao Spring Data que já fornece o método
    }


    public void save(Long id, String descricao, String valorOrcamento, boolean aprovado, Cliente cliente) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como PUT (Por conta do ID)
        OrdemServico ordemServico;

        if (id != null) {// Verifica se o ID está presente para decidir entre criar um novo cliente ou atualizar um existente
            ordemServico = ordemServicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico não encontrado com ID: " + id));
        } else {// Caso não tenha ID, cria um novo servico
            ordemServico = new OrdemServico();
        }

        // Atualiza os dados do cliente
        ordemServico.setDescricao(descricao);
        ordemServico.setValorOrcamento(valorOrcamento);
        ordemServico.setAprovado(aprovado);
        ordemServico.setCliente(cliente);

        // Salva o cliente no banco de dados
        ordemServicoRepository.save(ordemServico);//Esse "save" é graças ao Spring Data que já fornece o método
    }

    public void delete(Long id){//esse "delete" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como DELETE
        OrdemServico ordemServico = new OrdemServico();
        ordemServicoRepository.deleteById(id);//Esse "deleteById();" é graças ao Spring Data que já fornece o método
    }

}
