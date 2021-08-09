package br.com.dio.pointcontrol.service;


import br.com.dio.pointcontrol.model.User;
import br.com.dio.pointcontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long idUser) {
        return userRepository.findById(idUser);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long idUser) {
        userRepository.deleteById(idUser);
    }
}
