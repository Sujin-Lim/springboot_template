package org.example.springboot_test.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.example.springboot_test.entity.Notice;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {

    private int seq;
    private String title;   // 글 제목
    private String content; // 글 내용
    private String id;      // 작성자 id
    private int count;      // 글 조회수

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime regiDate;     // 글 등록일

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateDate;   // 글 수정일

    public static NoticeDto from(Notice notice) {
        return NoticeDto.builder()
                .seq(notice.getSeq())
                .title(notice.getTitle())
                .content(notice.getContent())
                .id(notice.getUserId())
                .count(notice.getCount())
                .regiDate(notice.getRegiDate())
                .updateDate(notice.getUpdateDate())
                .build();
    }

}
