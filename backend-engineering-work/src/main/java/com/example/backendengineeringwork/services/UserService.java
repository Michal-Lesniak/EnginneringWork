package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.commands.user.ChangePasswordCommand;
import com.example.backendengineeringwork.dtos.reservation.ReservationViewDto;
import com.example.backendengineeringwork.models.Role;
import com.example.backendengineeringwork.models.User;
import com.example.backendengineeringwork.dtos.user.UserDto;
import com.example.backendengineeringwork.dtos.user.UserProfileDto;
import com.example.backendengineeringwork.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ReservationService reservationService;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, ReservationService reservationService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.reservationService = reservationService;
    }

    public void changePassword(ChangePasswordCommand request, Principal connectedUser) {

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

    public UserProfileDto editUserProfileData(UserProfileDto editedUserProfile) {
        User userFromDb = userRepository.getReferenceById(editedUserProfile.id());
        User user = new User(
                editedUserProfile.id(),
                editedUserProfile.person(),
                editedUserProfile.mobilePhone(),
                editedUserProfile.email(),
                userFromDb.getPassword(),
                userFromDb.getRole(),
                userFromDb.getTokens());
        return mapToUserProfileDto(userRepository.save(user));
    }

    public UserProfileDto getUserProfileData(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if(user != null) {
            return mapToUserProfileDto(user);
        }else {
            return null;
        }
    }
    public List<UserDto> getListUsersDto() {
        List<User> userList = userRepository.findAll();
        return userList.stream().filter((user -> user.getRole() != Role.ADMIN)).map((user) -> new UserDto(user.getId(), user.getPerson(), user.getMobilePhone(), user.getEmail())).toList();
    }

    private UserProfileDto mapToUserProfileDto(User user){
        List<ReservationViewDto> reservationViewList = reservationService.getReservationByUserEmail(user.getEmail());
        return new UserProfileDto(user.getId(), user.getPerson(), user.getMobilePhone(), user.getEmail(), reservationViewList);
    }
}
