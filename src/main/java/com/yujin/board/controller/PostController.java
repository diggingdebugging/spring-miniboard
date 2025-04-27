package com.yujin.board.controller;

import com.yujin.board.domain.Post;
import com.yujin.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    // 메인 화면
    @GetMapping
    public String list() {
        return "/post/postList";
    }

    @GetMapping("/new")
    public String createForm() {
        return "post/postForm";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts";
    }
}
