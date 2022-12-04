package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);

    Comment getOneComment(Long commentId);

    Comment createOneComment(CommentCreateRequest commentCreateRequest);

    Comment updateOneComment(Long commentId, CommentUpdateRequest commentUpdateRequest);

    void deleteOneComment(Long commentId);
}
