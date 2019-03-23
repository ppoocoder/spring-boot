package com.bes.blog.controllers;

import java.util.Date;
import java.util.List;

import com.bes.blog.entities.Post;
import com.bes.blog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BlogController {
    @Autowired
    /**  스프링에서 @AutoWired 라는 이노테이션을 통해 의존성을 주입한다 .
       @Autowired는  속성의 설정자 메서드에 해당하는 역할을 자동으로 수행한다. 이와 비슷한 역할을 하는 자바 어노테이션으로는 @Resuourece 어노테이션이 있다. 
       두어노테이션의 차이는 bean을 탐색할 때 우선순위로 하는 기준이 어떤것이냐이다. 
       https://asfirstalways.tistory.com/334

    **/
    private PostService postService;

    @GetMapping(value= "/") //routinge connection 
    public String index(){
        return "index";
    }

    @GetMapping(value="/posts")  // posts의 모든 entities 객체 info를 list 형태로 받아와
    public List<Post> posts() {
       return postService.getAllPosts();
    }
    
    @PostMapping(value= "/post")  // Post entity
    public void pulbishPost(@RequestBody Post post) { 
      /*
      @RequestBody 어노테이션과 @ResponseBody 어노테이션은 각각 HTTP 요청 몸체를 자바 객체로 변환하고 자바 객체를 HTTP 응답 몸체로 변환하는 데 사용된다.
      @RequestBody 어노테이션을 이용하면 HTTP 요청 몸체를 자바 객체로 전달받을 수 있다. 비슷하게 @ResponseBody 어노테이션을 이용하면 자바 객체를 HTTP 응답 몸체로 전송할 수 있다.
        -- // @RequestBody 어노테이션은 @RequestMapping에 의해 POST 방식으로 전송된 HTTP 요청 데이터를 String 타입의 body 파라미터로 전달된다.(수신)
	// 그리고 @ResponseBody 어노테이션이 @RequestMapping 메서드에서 적용되면 해당 메서드의 리턴 값을 HTTP 응답 데이터로 사용한다.
    // simpleTest() 메서드의 리턴 값이 String 타입이므로 String 데이터를 HTTP 응답 데이터로 전송한다.(송신)
    https://devbox.tistory.com/entry/Spring-RequestBody-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EA%B3%BC-ReponseBody-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EC%9D%98-%EC%82%AC%EC%9A%A9
      */

            if (post.getDateCreated() ==null)
                post.setDateCreated(new Date());
            postService.insert(post);
    }
    
}