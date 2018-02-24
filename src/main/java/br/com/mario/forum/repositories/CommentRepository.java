package br.com.mario.forum.repositories;

import br.com.mario.forum.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mario on 23/02/18.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
