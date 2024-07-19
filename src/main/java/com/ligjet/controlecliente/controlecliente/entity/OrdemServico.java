package com.ligjet.controlecliente.controlecliente.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ligjet.controlecliente.controlecliente.service.OrdemServicoService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
@Getter//Anotação do Lombok usada para gerar automaticamente método de acesso (get)
@Setter//Anotação do Lombok usada para gerar automaticamente método de modificação (set)
@Entity//Anotação do JPA que define uma entidade persistente
public class OrdemServico {

    @Id//Anotação do JPA para criar o id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Anotação para gerar automaticamente o ID no banco de dados e anotações do JPA que define as propriedades do ID
    @Column(nullable = false, unique = true, name = "id")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private Long id;
    @Column(nullable = false, name = "descricao")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//Anotação para definir o formato da data e hora quando salvar no banco de dados
    @Column(nullable = false, name = "dataInicio")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private LocalDateTime dataInicio;
    @Column(nullable = false, name = "valorOrcamento")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private String valorOrcamento;
    @Column(name = "aprovado")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private boolean aprovado;

    @ManyToOne// Relacionamento muitos para um com Cliente
    @JoinColumn(name = "cliente_id", referencedColumnName="id")//Anotação pra gerar a coluna no banco de dados e anotações do JPA que define as propriedades da coluna
    private Cliente cliente;

    @PrePersist//Anotação do JPA utilizada para definir um método que deve ser executado antes que uma entidade seja persistida no banco de dados.
    public void prePersist() {
        this.dataInicio = LocalDateTime.now();
    }

    public OrdemServico() {
    }

    public OrdemServico(Long id, String descricao, String valorOrcamento, boolean aprovado) {
        this.id = id;
        this.descricao = descricao;
        this.valorOrcamento = valorOrcamento;
        this.aprovado = aprovado;
    }

}
