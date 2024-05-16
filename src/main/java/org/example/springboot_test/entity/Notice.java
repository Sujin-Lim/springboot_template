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
public class Notice {

    @Id
    @Column(name="SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(name="TITLE")
    private String title;   // 글 제목

    @Column(name="CONTENT")
    @Lob
    private String content; // 글 내용

    @Column(name="USER_ID")
    private String userId;

    @Column(name="COUNT")
    private int count;      // 글 조회수

    @Column(name="REGI_DATE")
    private LocalDateTime regiDate;

    @Column(name="UPDATE_DATE")
    private LocalDateTime updateDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

}
