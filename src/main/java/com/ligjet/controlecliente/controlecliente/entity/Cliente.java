package com.ligjet.controlecliente.controlecliente.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter//Anotação do Lombok usada para gerar automaticamente método de acesso (get)
@Setter//Anotação do Lombok usada para gerar automaticamente método de modificação (set)
@Entity//Anotação do JPA que define uma entidade persistente
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id//Anotação do JPA para criar o id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Anotação para gerar automaticamente o ID no banco de dados e anotações do JPA que define as propriedades do ID
    @Column(unique = true, name = "id", updatable = false)//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private Long id;
    @Column(nullable = false, name = "name")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private String name;
    @Column(nullable = false, name = "endereco")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private String endereco;
    @Column(nullable = false, unique = true, name = "telefone")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private Long telefone;
    @Column(nullable = false, name = "dataCadastro")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private String dataCadastro;

    @OneToMany(cascade = CascadeType.ALL)//Anotação para criar um relacionamento de um para muitos (1 cliente para varios serviços) e anotações do JPA que define as propriedades do relacionamento
    private List<OrdemServico> ordemServicos = new ArrayList<OrdemServico>();

    public Cliente(Long id, String name, String endereco, Long telefone, String dataCadastro) {
        this.id = id;
        this.name = name;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }
}

