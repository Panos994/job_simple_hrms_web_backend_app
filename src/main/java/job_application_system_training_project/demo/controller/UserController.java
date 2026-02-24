package job_application_system_training_project.demo.controller;

import job_application_system_training_project.demo.dto.UserRegisterRequestDTO;
import job_application_system_training_project.demo.dto.UserResponseDTO;
import job_application_system_training_project.demo.entity.User;
import job_application_system_training_project.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO){
        return ResponseEntity.ok(userService.registerUser(userRegisterRequestDTO)); //Controller return --> Response entity ποτε το service
    }

    //or DTO αντί για Entity
//    @PostMapping("/register")
//    public ResponseEntity<UserResponseDTO> registerUser(
//            @RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
//
//        User user = userService.registerUser(userRegisterRequestDTO);
//
//        UserResponseDTO response = UserResponseDTO.builder()
//                .id(user.getId())
//                .fullName(user.getFullname())
//                .email(user.getEmail())
//                .role(user.getRole())
//                .build();
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }

}
