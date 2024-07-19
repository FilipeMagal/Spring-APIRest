package com.ligjet.controlecliente.controlecliente.controller;

import com.ligjet.controlecliente.controlecliente.entity.Cliente;
import com.ligjet.controlecliente.controlecliente.entity.OrdemServico;
import com.ligjet.controlecliente.controlecliente.service.ClienteService;
import com.ligjet.controlecliente.controlecliente.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Anotação do framework Spring dizendo que é aqui a classe que será utilizada os principios de uma API REST
@RequestMapping("/ligjet/servico")//Endpoint padrão da aplicação da ordem de servico
public class OrdemServicoController {

    @Autowired// Injeção de dependencia, significando que o controller e o service dependem um do outro
    private OrdemServicoService ordemServicoService;


    @GetMapping("/servicos")//Utilizando o protocolo http do API REST para realizar operações como o GET (mostrar dados)
    public List<OrdemServico> findAllOrdemServico(){
        return ordemServicoService.findAllOrdemServico();//função feita no service para mostrar todos os servicos;
    }
    @GetMapping(value = "/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o GET (mostrar dados)
    public ResponseEntity <OrdemServico> findById(@PathVariable Long id){//Anotação do framework Spring
        OrdemServico OS = ordemServicoService.findById(id);//função feita no service para localizar o id;
        return ResponseEntity.ok().body(OS);//função do framework
    }
    @PostMapping("/create")//Utilizando o protocolo http do API REST para realizar operações como o POST (incluir dados)
    public void createServico(@RequestBody OrdemServico ordemServico) {//Anotação do framework Spring
        Cliente cliente = ordemServico.getCliente();

        ordemServico.setCliente(cliente); //sinceramente não entendi isso aqui, mas ok kkkkkkkkkkkkkkkk

        ordemServicoService.save(ordemServico.getDescricao(), ordemServico.getValorOrcamento(), ordemServico.isAprovado(), cliente);//função feita no service para salvar os dados;
    }

    @PutMapping("/create/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o PUT (alterar dados)
    public void putServico(@RequestBody OrdemServico ordemServico, @PathVariable Long id) {//Anotações do framework Spring
        Cliente cliente = ordemServico.getCliente();

        ordemServico.setCliente(cliente);

        ordemServicoService.save(id, ordemServico.getDescricao(), ordemServico.getValorOrcamento(), ordemServico.isAprovado(), cliente);//função feita no service para salvar os dados (em cima dos dados  que já foram salvos);
    }

    @DeleteMapping("/delete/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o DELETE (excluir dados)
    public void delete (@PathVariable Long id){//Anotação do framework Spring
        ordemServicoService.delete(id);//função feita no service para deletar os dados
    }
}
