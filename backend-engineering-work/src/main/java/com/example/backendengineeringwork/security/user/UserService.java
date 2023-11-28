package com.example.backendengineeringwork.security.user;

import com.example.backendengineeringwork.security.user.dto.UserProfileDto;
import com.example.backendengineeringwork.services.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService( PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserProfileDto getUserProfileData(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if(user != null) {
            return new UserProfileDto(user.getId(), user.getPerson(), user.getMobilePhone(), user.getEmail());
        }else {
            return null;
        }
    }
    public List<UserProfileDto> getListUsersDto() {
        List<User> userList = userRepository.findAll();
        return userList.stream().filter((user -> user.getRole() != Role.ADMIN)).map((user) -> new UserProfileDto(user.getId(), user.getPerson(), user.getMobilePhone(), user.getEmail())).toList();
    }
}
