package com.example.test.user;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private ArrayList<User> DbForUser;
    private int number = 0;

    @ApiOperation(value = "db init", notes = "사용할 db를 초기화한다 ")
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

    @PostMapping("/dataMap")
    @ApiImplicitParam(name = "key1", value = "the first key of paramMap", required = true)
    public ResponseEntity<?> getParams (@RequestParam HashMap paramMap){

        return ResponseEntity.ok(paramMap);
        // to do : return response with another dto
    }


}
