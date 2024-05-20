package org.example.springboot_test.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot_test.dto.UserDto;
import org.example.springboot_test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.springboot_test.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    // 로그인
    @Operation(summary = "일반 회원 로그인", description = "로그인")
    @ApiResponse(
            responseCode = "200",
            description = "로그인 성공"
    )
    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

    // 회원가입 - 일반
    @PostMapping("/guest")
    public void signUp(@RequestBody UserDto userDto) {
        userDto.setCreateDate(LocalDateTime.now());
        userDto.setUpdateDate(LocalDateTime.now());

        userService.signUp(userDto);
    }

    // 회원가입 - 일반
//    @PostMapping("/join")
//    public void signUpTest(@RequestParam("email") String email, @RequestParam("fcm") String fcm, @RequestParam("userId") String userId, @RequestParam("deviceId") String deviceId) {
//        UserDto userDto = new UserDto();
//        userDto.setUserEmail(email);
//        userDto.setFcm(fcm);
//        userDto.setUserId(userId);
//        userDto.setDeviceId(deviceId);
//        userDto.setCreateDate(LocalDateTime.now());
//        userDto.setUpdateDate(LocalDateTime.now());
//
//        userService.signUp(userDto);
//    }

    // 회원정보 - 일반
    @PostMapping("/info")
    public User getUserInfo(@RequestBody UserDto userDto) {
        return userService.getUserInfo(userDto);
    }

    // 회원가입 - 운영자
    @PostMapping("/admin")
    public void adminSignUp(@RequestBody UserDto userDto) {
        userDto.setCreateDate(LocalDateTime.now());
        userDto.setUpdateDate(LocalDateTime.now());

        userService.adminSignUp(userDto);
    }

    // 로그인 - 운영자: DB를 따로쓰나?
    @PostMapping("admin/login")
    public String adminLogin(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

    @PostMapping("/admin/info")
    public User getAdminInfo(@RequestBody UserDto userDto) {
        return userService.getUserInfo(userDto);
    }

    @PostMapping("/checkEmail")
    public String checkEmail(@RequestBody UserDto userDto) {
        String email = userDto.getUserEmail();
        return userService.checkEmail(email);
    }

    @PostMapping("/checkId")
    public String checkId(@RequestBody UserDto userDto) {
        String userId = userDto.getUserId();
        return userService.checkId(userId);
    }
}
