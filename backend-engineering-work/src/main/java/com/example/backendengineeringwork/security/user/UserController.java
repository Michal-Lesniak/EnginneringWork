package com.example.backendengineeringwork.security.user;

import com.example.backendengineeringwork.controllers.AbstractController;
import com.example.backendengineeringwork.security.user.User;
import com.example.backendengineeringwork.security.user.dto.UserDto;
import com.example.backendengineeringwork.security.user.dto.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

   private final UserService userService;

   public UserController( UserService userService) {
       this.userService = userService;
   }
    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> listUserDto = userService.getListUsersDto();
        return ResponseEntity.ok().body(listUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDto> editUserProfileData(@RequestBody UserProfileDto editedUserProfile){
        if (userService.findById(editedUserProfile.id()).isPresent()) {
            return ResponseEntity.ok().body(userService.editUserProfileData(editedUserProfile));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/getByEmail")
    public ResponseEntity<UserProfileDto> getUserProfileData(@RequestBody String email){
        UserProfileDto userProfileDto = userService.getUserProfileData(email);
        if(userProfileDto != null){
            return ResponseEntity.ok().body(userProfileDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
