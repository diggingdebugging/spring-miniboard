package com.yujin.board.domain.repository;

import com.yujin.board.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryPostRepository implements PostRepository {
    private final Map<Long, Post> store = new HashMap<>();
    private final Long sequence = 0L;

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public Post findById(Long id) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public void update(Long id, Post updatedPost) {

    }

    @Override
    public void delete(Long id) {

    }
}
