package org.example.project.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.project.entity.User;
import org.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
    private final UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
        System.out.println("Elave olundu save");
    }
//
//    @Override
//    public void update(User user) {
//        if(!userRepository.existsById(user.getId())) {
//            userRepository.save(user);
//            System.out.println("Elave olundu amma yenisi uypdate");
//        }else{
//            this.userRepository.save(user);
//            System.out.println("Elave olundu uypdate");
//        }
//    }

    @Override
    public void delete(User user) {
        if(userRepository.existsById(user.getId())) {
            userRepository.deleteById(user.getId());
            System.out.println("Data silindi");
        }else{
            System.out.println("Data silinmedi");
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
       return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
      return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}