package com.sd.backend.service;

import com.sd.backend.domain.ConsultaDTO;
import com.sd.backend.model.Consulta;
import com.sd.backend.repository.ConsultaRepository;
import com.sd.backend.service.exceptions.DatabaseException;
import com.sd.backend.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Transactional(readOnly = true)
    public Page<ConsultaDTO> findAllPaged(Pageable pageable){
        Page<Consulta> list = repository.findAll(pageable);
        return list.map(ConsultaDTO::new);
    }

    @Transactional(readOnly = true)
    public ConsultaDTO findById(Long id) {
        Optional<Consulta> obj = repository.findById(id);
        Consulta entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ConsultaDTO(entity);
    }

    @Transactional
    public ConsultaDTO insert(ConsultaDTO dto) {
        Consulta entity = new Consulta();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ConsultaDTO(entity);
    }

    @Transactional
    public ConsultaDTO update(Long id, ConsultaDTO dto) {
        try {
            Consulta entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ConsultaDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(ConsultaDTO dto, Consulta entity) {
        entity.setId(dto.getId());
        entity.setPressaoArterial(dto.getPressaoArterial());
        entity.setFrequenciaCardiaca(dto.getFrequenciaCardiaca());
        entity.setNivelOxigenio(dto.getNivelOxigenio());
        entity.setPaciente(dto.getPaciente());
        entity.setSintomas(dto.getSintomas());
        entity.setDiagnostico(dto.getDiagnostico());
    }
}
