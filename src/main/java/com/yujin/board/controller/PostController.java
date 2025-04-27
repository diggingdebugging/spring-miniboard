package com.yujin.board.controller;

import com.yujin.board.domain.Post;
import com.yujin.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    // 메인 화면
    @GetMapping
    public String list(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
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

    @GetMapping("/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id);
        model.addAttribute("post", post);
        return "post/postDetail";
    }
}
