package br.com.dio.pointcontrol.service;

import br.com.dio.pointcontrol.model.WorkingDay;
import br.com.dio.pointcontrol.repository.WorkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class WorkingService {

    @Autowired
    WorkingRepository workingRepository;

    public WorkingDay saveWork(WorkingDay workingDay){
      return  workingRepository.save(workingDay);
    }

    public List<WorkingDay> findAll() {
        return workingRepository.findAll();
    }

    public Optional<WorkingDay> findById(Long idWorking) {
        return workingRepository.findById(idWorking);
    }

    public WorkingDay updateWork(WorkingDay workingDay){
        return  workingRepository.save(workingDay);
    }

    public void deleteWork(Long idWorking) {
        workingRepository.deleteById(idWorking);
    }

    public WorkingDay updateWorkingDay(WorkingDay workingDay) {
        return workingRepository.save(workingDay);
    }

    public void deleteWorkingDay(Long idWorking) {
        workingRepository.deleteById(idWorking);
    }
}
