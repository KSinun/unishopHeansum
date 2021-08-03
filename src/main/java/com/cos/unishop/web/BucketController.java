package com.cos.unishop.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.unishop.bucket.Bucket;
import com.cos.unishop.bucket.BucketRepository;
import com.cos.unishop.domain.post.PostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BucketController {
	
	private final HttpSession session;
	private final PostRepository postEntity;
	private final BucketRepository bucketRepository;
	
	
//	@GetMapping("/bucket/{id}")
//	public void InputBucket(@PathVariable int id) {
		// id 잡아서 이아이디의 버켓에 저장
		// 그러기 위해서는 postentity와 bucketentity 필요
//		Bucket bucketEntity = bucketRepository.findById(id).get();
//	
//	}
}
