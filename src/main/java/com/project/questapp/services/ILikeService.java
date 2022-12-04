package com.project.questapp.services;

import com.project.questapp.entities.Like;
import com.project.questapp.requests.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface ILikeService {
    List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId);

    Like getOneLike(Long likeId);

    Like createOneLike(LikeCreateRequest request);

    void deleteOneLikeById(Long likeId);
}
