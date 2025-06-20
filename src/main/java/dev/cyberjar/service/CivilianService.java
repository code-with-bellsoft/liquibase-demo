package dev.cyberjar.service;

import dev.cyberjar.entity.Civilian;
import dev.cyberjar.repository.CivilianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilianService {

    private final CivilianRepository civilianRepository;

    public CivilianService(CivilianRepository civilianRepository) {
        this.civilianRepository = civilianRepository;
    }

    public List<Civilian> findAll() {
        return civilianRepository.findAll();
    }


}



