package com.yujin.board.domain.repository;

import com.yujin.board.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryPostRepository implements PostRepository {
    private final Map<Long, Post> store = new HashMap<>();
    private long sequence = 0L; //새로운 게시물에 적용되는 아이디 값, 게시물이 생성될 때 save에서 1씩증가.

    //create
    @Override
    public Post save(Post post) {
        post.setId(sequence++);
        store.put(post.getId(), post);
        return post;
    }

    //read
    @Override
    public Post findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    // update
    @Override
    public void update(Long id, Post updatedPost) {
        Post post = findById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
    }

    //delete
    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}
