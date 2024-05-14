package org.example.springboot_test.service;

import org.example.springboot_test.dto.UserDto;
import org.example.springboot_test.entity.User;
import org.example.springboot_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(UserDto userDto) {
        // UserDto에서 User 엔티티로 변환
        User user = User.builder()
                .userId(userDto.getUserId())
                .userPw(userDto.getUserPw())
                .userName(userDto.getUserName())
                .userEmail(userDto.getUserEmail())
                .userType("N")
                .build();

        // UserRepository를 사용하여 회원 정보 저장
        userRepository.save(user);
    }

    public List<UserDto> getUsers() {
        // UserRepository를 사용하여 모든 회원 정보 조회
        List<User> userList = userRepository.findAll();

        // User 엔티티를 UserDto로 변환하여 반환
        return userList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // User 엔티티를 UserDto로 변환하는 메서드
    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userEmail(user.getUserEmail())
                .createDate(user.getCreateDate())
                .updateDate(user.getUpdateDate())
                .build();
    }
}