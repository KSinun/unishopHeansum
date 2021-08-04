package com.cos.unishop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.unishop.domain.post.PostRepository;
import com.cos.unishop.domain.user.User;
import com.cos.unishop.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyPageController {

	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	
	//마이페이지로 가는 컨트롤러
	@GetMapping("/myPage")
	public String bucket() {
		return"user/myPage";
	}
	//상품평관리하기로 가는 컨트롤러
	@GetMapping("/CommentsManagement")
	public String CommentsManagement() {
		return"user/commentsManagement";
	}
	//장바구니로 가는 컨트롤러
	//지금은 페이지만 연결해놓은거
	//나중에 모델에 담에서뿌려야함 ㅇㅋ?
	
	@GetMapping("/bucket/{id}")
	public String myPage(@PathVariable int id, Model model) {
		User userEntity = userRepository.findById(id).get();
		model.addAttribute("userEntity", userEntity);
		return"user/bucket";
	}
	
	@GetMapping("/paymentList")
	public String paymentList() {
		return "user/paymentList";
	}
	
}
