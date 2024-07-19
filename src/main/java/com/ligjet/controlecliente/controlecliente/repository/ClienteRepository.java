package com.ligjet.controlecliente.controlecliente.repository;

import com.ligjet.controlecliente.controlecliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Anotação do framework indica que a classe é um componente para acesso a dados
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
    //Classe feita juntamente com JPA e Spring Data para facilitar a implementação de acesso aos dados com o repositorio

}
