package com.api.reserva.service;

import com.api.reserva.dto.AmbienteDTO;
import com.api.reserva.dto.TipoDTO;
import com.api.reserva.entity.Ambiente;
import com.api.reserva.entity.Tipo;
import com.api.reserva.exception.SemResultadosException;
import com.api.reserva.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TipoService {
    @Autowired
    private TipoRepository repository;

    public TipoDTO listar(Long id) {
        return new TipoDTO(repository.findById(id).orElseThrow(() -> new SemResultadosException()));
    }

    public List<TipoDTO> listar() {
        List<Tipo> tipos = repository.findAll();
        return tipos.stream()
                .map(TipoDTO::new)
                .toList();
    }






}
