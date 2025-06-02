package com.dongyang.dohyeonAclass01.entity;
import com.dongyang.dohyeonAclass01.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;

    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {

        if (dto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        if (dto.getArticleId() != article.getId())
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됐습니다.");

        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }
    public void patch(CommentDto dto) {
        // 예외 발생
        if (this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력됐습니다.");

        if (dto.getNickname() != null) // 수정할 닉네임 데이터가 있다면
            this.nickname = dto.getNickname(); // 내용을 반영

        if (dto.getBody() != null) // 수정할 본문 데이터가 있다면
            this.body = dto.getBody(); // 내용을 반영
    }


}

