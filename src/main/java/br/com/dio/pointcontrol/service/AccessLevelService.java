package br.com.dio.pointcontrol.service;

import br.com.dio.pointcontrol.model.AccessLevel;
import br.com.dio.pointcontrol.model.WorkingDay;
import br.com.dio.pointcontrol.repository.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    AccessLevelRepository accessLevelRepository;

    @Autowired
    public AccessLevelService(AccessLevelRepository accessLevelRepository) {
        this.accessLevelRepository = accessLevelRepository;
    }

    public AccessLevel saveAccess(AccessLevel accessLevel){
        return accessLevelRepository.save(accessLevel);
    }

    public List<AccessLevel> findAll() {
        return accessLevelRepository.findAll();
    }

    public Optional<AccessLevel> findById(Long idAccessLevel) {
        return accessLevelRepository.findById(idAccessLevel);
    }

    public AccessLevel updateAccess(AccessLevel accessLevel) {
        return accessLevelRepository.save(accessLevel);
    }

    public void deleteAccess(Long idAccessLevel) {
        accessLevelRepository.deleteById(idAccessLevel);
    }
}
