package com.example.backendengineeringwork.security.user;

import com.example.backendengineeringwork.security.user.dto.UserProfileDto;
import com.example.backendengineeringwork.services.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserService extends AbstractService<User, Long> {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(JpaRepository<User, Long> repository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        super(repository);
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
        this.save(user);
    }

    public UserProfileDto getUserProfileData(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if(user != null) {
            return new UserProfileDto(user.getId(), user.getPerson(), user.getMobilePhone(), user.getEmail());
        }else {
            return null;
        }
    }
}
