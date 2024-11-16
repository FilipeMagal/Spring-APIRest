package com.ligjet.controlecliente.controlecliente.service;

import com.ligjet.controlecliente.controlecliente.controlecliente.entity.Cliente;
import com.ligjet.controlecliente.controlecliente.controlecliente.repository.ClienteRepository;
import com.ligjet.controlecliente.controlecliente.controlecliente.service.ClienteService;
import com.ligjet.controlecliente.controlecliente.controlecliente.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    ClienteServiceImpl service;

    @Mock
    ClienteRepository repository;

    Cliente cliente;

    @BeforeEach
    public void setUp(){
        cliente = new Cliente(1L, "Filipe Lima", "Rua conde de Porto alegre", 71992942415L, "09/11/2024");
    }

    @Test
    void deveBuscarPessoasPorIdComSucesso(){
        when(repository.findById(cliente.getId())).thenReturn(Optional.of(cliente));
        Cliente result = service.findById(cliente.getId());

        assertEquals(cliente, result);
        verify(repository).findById(cliente.getId());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void naoDeveChamarORepositoryCasoIdNull(){
        final RuntimeException e = assertThrows(RuntimeException.class, () -> {
            service.save(null, "", "", 1L, "");
        });

        // Verifica se a exceção não é nula
        assertThat(e, notNullValue());

        // Verifica se a mensagem da exceção está correta
        assertThat(e.getMessage(), is("Cliente não encontrado com ID: null"));

        // Verifica que o repositório não foi chamado
        verifyNoInteractions(repository);

    }


}
