package com.example.backendengineeringwork.security.user;

import com.example.backendengineeringwork.controllers.AbstractController;
import com.example.backendengineeringwork.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends AbstractController<User, Long> {

   private final UserService userService;

   public UserController( UserService userService) {
       super(userService);
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

    @PostMapping("/getRoles")
    public ResponseEntity<List<String>> getRoles(@RequestBody String email){
        return ResponseEntity.ok().body(userService.getRoles(email));
    }
}
