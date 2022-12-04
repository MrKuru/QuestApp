package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> getAllPosts(Optional<Long> userId);

    Post getOnePost(Long postId);

    Post createOnePost(PostCreateRequest newPostRequest);

    Post updateOnePost(Long postId, PostUpdateRequest postUpdateRequest);

    void deleteOnePost(Long postId);
}
