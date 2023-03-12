package com.codestates.QA.entity;

import com.codestates.audit.Auditable;
import com.codestates.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bord extends Auditable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long bordId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String detail;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private BordStatus bordStatus = BordStatus.QUESTION_REGISTRATION;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private BordRange bordRange = BordRange.QUESTION_PUBLIC;

    public enum BordStatus {
        QUESTION_REGISTRATION("질문 등록 상태"),
        QUESTION_ANSWERED("답변 완료 상태"),
        QUESTION_DELETE("질문 삭제 상태");

        @Getter
        private String status;

        BordStatus(String status) {
            this.status = status;
        }
    }
    public enum BordRange {
        QUESTION_PUBLIC("공개글 상태"),
        QUESTION_SECRET("비밀글 상태");

        @Getter
        private String range;

        BordRange(String range) {
            this.range = range;
        }
    }


}
