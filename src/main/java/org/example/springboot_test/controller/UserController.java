package org.example.springboot_test.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot_test.dto.UserDto;
import org.example.springboot_test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.springboot_test.service.UserService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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

    @PostMapping("/getUserInfo")
    public User getUserInfo(@RequestBody UserDto userDto) {
        return userService.getUserInfo(userDto);
    }

    // 회원 목록 조회
    @GetMapping
    public List<UserDto> getUsers() {

        return userService.getUsers();
    }
}
