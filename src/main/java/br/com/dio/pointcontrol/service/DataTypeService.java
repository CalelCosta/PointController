package br.com.dio.pointcontrol.service;

import br.com.dio.pointcontrol.model.DataType;
import br.com.dio.pointcontrol.repository.DataTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataTypeService {

    DataTypeRepository dataTypeRepository;

    @Autowired
    public DataTypeService(DataTypeRepository dataTypeRepository) {
        this.dataTypeRepository = dataTypeRepository;
    }

    public DataType save(DataType dataType) {
        return dataTypeRepository.save(dataType);
    }

    public List<DataType> findAll() {
        return dataTypeRepository.findAll();
    }

    public Optional<DataType> findById(Long idDataType) {
        return dataTypeRepository.findById(idDataType);
    }

    public DataType updateDataType(DataType dataType) {
        return dataTypeRepository.save(dataType);
    }

    public void deleteDataType(Long idDataType) {
        dataTypeRepository.deleteById(idDataType);
    }
}
