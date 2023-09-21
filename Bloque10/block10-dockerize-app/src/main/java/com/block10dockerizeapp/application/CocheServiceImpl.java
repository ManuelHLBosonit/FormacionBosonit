package com.block10dockerizeapp.application;
import com.block10dockerizeapp.domain.Coche;
import com.block10dockerizeapp.infrastructure.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class CocheServiceImpl implements CocheService {

    @Autowired
    CocheRepository cocheRepository;

    @Override
    public Coche addCoche(Coche coche) {
        return cocheRepository.save(coche);
    }


    public Coche getCocheById(String cocheId) {
        return cocheRepository.findById(cocheId).orElseThrow(() -> {
            throw new NotFoundException("La id " + cocheId + " no se ha podido encontrar");
        });
    }
}
