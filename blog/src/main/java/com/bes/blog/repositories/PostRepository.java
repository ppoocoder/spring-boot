package com.bes.blog.repositories;

import com.bes.blog.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // db entitiesf를 interface화 시켜 jpa repo 형태로 사용하게끔 정의 
public interface PostRepository extends JpaRepository<Post,Long>{


}