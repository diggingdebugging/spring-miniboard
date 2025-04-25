package com.yujin.board.domain.repository;

import com.yujin.board.domain.Post;

import java.util.List;

public interface PostRepository {
    // create
    Post save(Post post);
    // read
    Post findById(Long id);
    List<Post> findAll();
    // update
    void update(Long id, Post updatedPost);
    // delete
    void delete(Long id);
}
