package org.example.springboot_test.controller;

import org.example.springboot_test.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.springboot_test.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public void signUp(@RequestBody UserDto userDto) {
        userDto.setCreateDate(LocalDateTime.now());
        userDto.setUpdateDate(LocalDateTime.now());

        userService.signUp(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

    // 회원 목록 조회
    @GetMapping
    public List<UserDto> getUsers() {

        return userService.getUsers();
    }
}
