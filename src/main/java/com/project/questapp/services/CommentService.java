package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repository.CommentRepository;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;


    @Override
    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId, postId);
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId);
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId);
        }
        else
            return commentRepository.findAll();
    }
    @Override
    public Comment getOneComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }
    @Override
    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOneUserById(commentCreateRequest.getUserId());
        Post post = postService.getOnePost(commentCreateRequest.getPostId());
        if (user != null && post != null){
            Comment toSaveComment = new Comment();
            toSaveComment.setUser(user);
            toSaveComment.setPost(post);
            toSaveComment.setId(commentCreateRequest.getId());
            toSaveComment.setText(commentCreateRequest.getText());
            return commentRepository.save(toSaveComment);
        }
        return null;
    }
    @Override
    public Comment updateOneComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment toUpdateComment = comment.get();
            toUpdateComment.setText(commentUpdateRequest.getText());
            return commentRepository.save(toUpdateComment);
        }
        return null;
    }
    @Override
    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
