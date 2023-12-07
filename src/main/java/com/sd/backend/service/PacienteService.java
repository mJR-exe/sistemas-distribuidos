package com.sd.backend.service;

import com.sd.backend.domain.PacienteDTO;
import com.sd.backend.model.Paciente;
import com.sd.backend.repository.PacienteRepository;
import com.sd.backend.service.exceptions.DatabaseException;
import com.sd.backend.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Transactional(readOnly = true)
    public Page<PacienteDTO> findAllPaged(Pageable pageable){
        Page<Paciente> list = repository.findAll(pageable);
        return list.map(PacienteDTO::new);
    }

    @Transactional(readOnly = true)
    public PacienteDTO findById(Long id) {
        Optional<Paciente> obj = repository.findById(id);
        Paciente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PacienteDTO(entity);
    }

    @Transactional
    public PacienteDTO insert(PacienteDTO dto) {
        Paciente entity = new Paciente();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PacienteDTO(entity);
    }

    @Transactional
    public PacienteDTO update(Long id, PacienteDTO dto) {
        try {
            Paciente entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new PacienteDTO(entity);
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

    private void copyDtoToEntity(PacienteDTO dto, Paciente entity) {
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setSexo(dto.getSexo());
        entity.setFuma(dto.getFuma());
        entity.setBebe(dto.getBebe());
        entity.setPraticaExercicio(dto.getPraticaExercicio());
        entity.setInfartou(dto.getInfartou());
        entity.setAlimentacao(dto.getAlimentacao());
        entity.setDescricaoSintomas(dto.getDescricaoSintomas());
    }
}
