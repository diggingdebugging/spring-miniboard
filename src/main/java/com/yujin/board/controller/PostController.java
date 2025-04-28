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

    // 메인 화면 요청
    @GetMapping
    public String list(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "/post/postList";
    }

    // 게시물 등록 화면 요청
    @GetMapping("/new")
    public String createForm() {
        return "post/postForm";
    }

    // 게시물 등록 후 변경사항 저장 및 리다이렉트
    @PostMapping("/new")
    public String save(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts";
    }

    // 게시물 세부사항 요청
    @GetMapping("/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id);
        model.addAttribute("post", post);
        return "post/postDetail";
    }

    // 게시물 수정 요청
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id);
        model.addAttribute("post", post);
        return "post/postEdit";
    }

    @PostMapping("/{id}/edit")
    public String updatePost(@PathVariable Long id,@ModelAttribute Post updatedPost) {
        postRepository.update(id, updatedPost);
        return "redirect:/posts/" + id;
    }
}
