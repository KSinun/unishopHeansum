package com.cos.unishop.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.unishop.bucket.Bucket;
import com.cos.unishop.bucket.BucketRepository;
import com.cos.unishop.domain.post.PostRepository;
import com.cos.unishop.domain.user.User;
import com.cos.unishop.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BucketController {
	
	private final HttpSession session;
	private final PostRepository postEntity;
	private final BucketRepository bucketRepository;
	private final UserRepository userRepository;
	
	@PostMapping("/bucket/save")
	public String inputBucket(@RequestBody Bucket bucket) {
		System.out.println(" inputBucket 나실행됨?");
//		Bucket bucketEntity = bucketRepository.findById(id).get();
		// user 가져오기
		
		bucketEntity.setUser(bucket.getUser().getUsername());
		System.out.println("나실행됨? "+bucketEntity.getUser());
		// product 가져오기
		bucketEntity.setProducts(bucket.getProducts());
		System.out.println("나실행됨?");
		// product 안의 size 가져오기
		bucketEntity.getProducts().setSize(bucket.getProducts().getSize());
		// product 안의 image 가져오기
		bucketEntity.getProducts().setImage(bucket.getProducts().getImage());
		
		bucketRepository.save(bucketEntity);
		return "redirect:/bucket/{id}";
	}
	
	@GetMapping("/bucket/{id}")
	public String inputBucket(@PathVariable int id, Model model) {
//		 id 잡아서 이아이디의 버켓에 저장
//		 그러기 위해서는 postentity와 bucketentity 필요
		System.out.println("나실행됨?");
		
		User userEntity = userRepository.findById(id).get();
		List<Bucket> bucketEntity = userEntity.getBucket();
		System.out.println("나실행됨");
//		Bucket bucketEntity = bucketRepository.findById(id).get();
		model.addAttribute(bucketEntity);
		return "user/bucket";
	}
	
	
}
