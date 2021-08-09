package br.com.dio.pointcontrol.service;

import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.repository.AnnualLeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnualLeaveService {

    AnnualLeaveRepository annualLeaveRepository;

    @Autowired
    public AnnualLeaveService(AnnualLeaveRepository annualLeaveRepository) {
        this.annualLeaveRepository = annualLeaveRepository;
    }

    public AnnualLeave save(AnnualLeave annualLeave) {
        return this.annualLeaveRepository.save(annualLeave);
    }

    public List<AnnualLeave> findAll() {
        return annualLeaveRepository.findAll();
    }

    public AnnualLeave updateAnnualLeave(AnnualLeave annualLeave) {
        return annualLeaveRepository.save(annualLeave);
    }

    public void deleteAnnualLeave(Long idBancoHoras) {
        annualLeaveRepository.deleteById(idBancoHoras);
    }

    public Optional<AnnualLeave> findById(Long idAnnualLeave) {
        return annualLeaveRepository.findById(idAnnualLeave);
    }
}
