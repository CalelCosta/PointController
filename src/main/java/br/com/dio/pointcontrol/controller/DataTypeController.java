package br.com.dio.pointcontrol.controller;

import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.model.DataType;
import br.com.dio.pointcontrol.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/dataType")
public class DataTypeController {

    @Autowired
    DataTypeService dataTypeService;

    @PostMapping
    public DataType createDataType(@RequestBody DataType dataType) {
        return dataTypeService.save(dataType);
    }

    @GetMapping
    public List<DataType> getDataTypeList(){
        return dataTypeService.findAll();
    }

    @GetMapping("/{idDataType}")
    public DataType getDataTypeById(@PathVariable("idDataType") Long idDataType) throws Exception {
        return dataTypeService.findById(idDataType).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @PutMapping
    public DataType updateDataType(@RequestBody DataType dataType){
        return dataTypeService.updateDataType(dataType);
    }

    @DeleteMapping("/{idDataType}")
    public ResponseEntity deleteByID(@PathVariable("idDataType") Long idDataType) throws Exception {
        try {
            dataTypeService.deleteDataType(idDataType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
    }
}
