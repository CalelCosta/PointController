package br.com.dio.pointcontrol.service;

import br.com.dio.pointcontrol.model.UserCategory;
import br.com.dio.pointcontrol.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsercategoryService {

    UserCategoryRepository userCategoryRepository;

    @Autowired
    public UsercategoryService(UserCategoryRepository userCategoryRepository) {
        this.userCategoryRepository = userCategoryRepository;
    }


    public UserCategory save(UserCategory userCategory) {
        return userCategoryRepository.save(userCategory);
    }

    public List<UserCategory> findAll() {
        return userCategoryRepository.findAll();
    }

    public Optional<UserCategory> findById(Long idUserCategory) {
        return userCategoryRepository.findById(idUserCategory);
    }

    public UserCategory updateUserCategory(UserCategory userCategory) {
        return userCategoryRepository.save(userCategory);
    }

    public void deleteUserCategory(Long idUserCategory) {
        userCategoryRepository.deleteById(idUserCategory);
    }
}
