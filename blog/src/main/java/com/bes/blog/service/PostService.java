package com.bes.blog.service;

import java.util.List;

import com.bes.blog.entities.Post; // (db entities) Model 
import com.bes.blog.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // controller에서 사용될 def 단위의 코드를 작성 
public class PostService {
     @Autowired
    private PostRepository postRepository;  // import 객체와 @autowired의 차이가 무엇인가.... ??? 

    public List<Post> getAllPosts(){
        return postRepository.findAll(); // 모든 post repo info 를 list로 찾다 
    }

    public void insert(Post post){
        postRepository.save(post);
    } 
}