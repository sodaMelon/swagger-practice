package com.example.test.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private ArrayList<User> DbForUser;
    private int number = 0;

    @GetMapping("/init")
    public ResponseEntity init() {
        DbForUser = new ArrayList<>();
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/user/{id}")
    public ResponseEntity<?> createUser(@PathVariable String id) {
        User newUser = new User(id, number);
        DbForUser.add(newUser);
        number++;
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users")
    public ResponseEntity<?> readAll(){
        return ResponseEntity.ok(DbForUser);
    }

    @GetMapping("/user/{number}")
    public ResponseEntity<?> readOneUser(@PathVariable int number) {
        User target = DbForUser.get(number);
        return ResponseEntity.ok(target);
    }


}
