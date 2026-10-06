package com.ticket.support_ticket_management.Service;

import com.ticket.support_ticket_management.Model.User;
import com.ticket.support_ticket_management.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User user) {

        User existingUser = getUserById(id);

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setDepartment(user.getDepartment());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}