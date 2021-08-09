package br.com.dio.pointcontrol.controller;

import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.model.Company;
import br.com.dio.pointcontrol.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.save(company);
    }

    @GetMapping
    public List<Company> getCompanyList(){
        return companyService.findAll();
    }

    @GetMapping("/{idCompany}")
    public Company getCompanyById(@PathVariable("idCompany") Long idCompany) throws Exception {
        return companyService.findById(idCompany).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/{idCompany}")
    public ResponseEntity deleteByID(@PathVariable("idCompany") Long idCompany) throws Exception {
        try {
            companyService.deleteCompany(idCompany);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
    }
}
