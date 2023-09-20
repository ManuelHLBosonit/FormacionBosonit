package com.block7crud.asignatura.application;

import com.block7crud.asignatura.domain.Asignatura;
import com.block7crud.asignatura.domain.AsignaturaMapper;
import com.block7crud.asignatura.infrastructure.dto.AsignaturaOutputDto;
import com.block7crud.asignatura.infrastructure.repository.AsignaturaRepository;
import com.block7crud.student.domain.Student;
import com.block7crud.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Asignatura addAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura getAsignaturaById(String id) {
        return asignaturaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encuentra la ID de la asignatura")
        );
    }

    @Override
    public List<AsignaturaOutputDto> getAllAsignaturas() {
        return asignaturaRepository.findAll()
                .stream()
                .map(asignatura ->  AsignaturaMapper.INSTANCE.AsignaturaToAsignaturaOutputDto(asignatura)).toList();
    }

    @Override
    public Asignatura updateAsignatura(Asignatura asignatura) {
        asignaturaRepository.findById(asignatura.getId_asignatura()).orElseThrow(
                () -> new NotFoundException("No se encuentra la ID de la asignatura")
        );

        asignaturaRepository.save(asignatura);

        return asignatura;
    }

    @Override
    public String deleteById(String id) {
        asignaturaRepository.findById(id).ifPresentOrElse(
                existe -> {
                    asignaturaRepository.deleteById(id);

                },
                () -> {
                    throw new NotFoundException("La id " + id + " no se ha podido encontrar");
                }
        );
        return "Id " + id + " eliminado correctamente";
    }
}
