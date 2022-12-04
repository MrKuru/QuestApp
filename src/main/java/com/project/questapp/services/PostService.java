package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repository.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService{

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }else
            return postRepository.findAll();
    }

    @Override
    public Post getOnePost(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }
    @Override
    public Post createOnePost(PostCreateRequest postCreateRequest) {
        User user = userService.getOneUserById(postCreateRequest.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(postCreateRequest.getId());
        toSave.setText(postCreateRequest.getText());
        toSave.setTitle(postCreateRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }
    @Override
    public Post updateOnePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> updatablePost = postRepository.findById(postId);
        if (updatablePost.isPresent()){
            Post toUpdate = updatablePost.get();
            toUpdate.setText(postUpdateRequest.getText());
            toUpdate.setTitle(postUpdateRequest.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }
    @Override
    public void deleteOnePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
