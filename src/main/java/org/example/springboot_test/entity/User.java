package org.example.springboot_test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @Column(name="SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userSeq;

    @Column(name="ID")
    private String userId;

    @Column(name="PW")
    private String userPw;

    @Column(name="NAME")
    private String userName;

    @Column(name="EMAIL")
    private String userEmail;

    @Column(name="TYPE")
    private String userType;

    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name="UPDATE_DATE")
    private LocalDateTime updateDate;

}
