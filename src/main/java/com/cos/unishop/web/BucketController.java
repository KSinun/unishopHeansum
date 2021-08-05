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
import com.cos.unishop.bucket.BucketProducts;
import com.cos.unishop.bucket.BucketProductsRepository;
import com.cos.unishop.bucket.BucketRepository;
import com.cos.unishop.domain.post.Post;
import com.cos.unishop.domain.post.PostRepository;
import com.cos.unishop.domain.user.User;
import com.cos.unishop.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BucketController {
	
	private final HttpSession session;
	private final PostRepository postRepository;
	private final BucketRepository bucketRepository;
	private final UserRepository userRepository;
	private final BucketProductsRepository bucketProductsRepository;
	
	@PostMapping("/bucket/{id}")
	public @ResponseBody String input(@PathVariable int id, @RequestBody BucketProducts bucket) {
		Post postEntity = postRepository.findById(id).get();
		postEntity.getId(); // post 프라이머리 id
		
		User principal = (User) session.getAttribute("principal");
		
		
		BucketProducts bucketEntity = null;
		
		bucketEntity.setPrice(postEntity.getPrice());
		bucketEntity.setImage(postEntity.getImage());
		bucketEntity.setSize(postEntity.getSize());
		bucketEntity.setProductname(postEntity.getProductname());
		
		// 버켓 형태로 만든 다음에 저장!
		// 빈껍데기라도 만들자
		bucketProductsRepository.save(bucketEntity);
		
//		int UserId = principal.getId();
//		
//		
//		BucketProducts bucketEntity = bucketProductsRepository.getById(UserId);
//		
//		bucketEntity.setUser(principal);
//		bucketProductsRepository.save(bucketEntity);
		
//		bucketEntity.setImage(postEntity.getImage());
//		bucketEntity.setPrice(postEntity.getPrice());
//		bucketEntity.setSize(postEntity.getSize());
//		bucketEntity.setProductname(postEntity.getProductname());
		
//		bucketProductsRepository.save(bucketEntity);
		
		return "ok";
	}
	
	
	
	
//	@PostMapping("/bucket/save")
//	public String inputBucket(@RequestBody Bucket bucket) {
//		System.out.println(" inputBucket 나실행됨?");
//
//		User principal = (User) session.getAttribute("principal");
//
//		
//		
//		String id = Integer.toString(principal.getId());
//		bucketRepository.save(bucket);
//		return "redirect:/bucket/"+id;
//	}
	
	@GetMapping("/bucket/{id}")
	public String showBucket(@PathVariable int id, Model model) {
//		 id 잡아서 이아이디의 버켓에 저장
//		 그러기 위해서는 postentity와 bucketentity 필요
		System.out.println("get 장바구니 나실행됨?");
		
		User userEntity = userRepository.findById(id).get();
//		List<Bucket> bucketEntity = userEntity.getBucket();
		
		BucketProducts bucketEntity = bucketProductsRepository.findById(id).get();
		
		System.out.println("마지막 나실행됨>?");
//		Bucket bucketEntity = bucketRepository.findById(id).get();
		model.addAttribute(bucketEntity);
		return "user/bucket";
	}
	
	
}
