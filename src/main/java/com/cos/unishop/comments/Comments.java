package com.cos.unishop.comments;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.unishop.domain.post.Post;
import com.cos.unishop.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class Comments {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id; // 프라이머리키 (기본키)
//	
//	// @ 맵핑
////	@JsonIgnoreProperties({"user"})
//	@JoinColumn(name = "user_id")
//	@ManyToOne
//	private User user;
//	
//	private int satisfication;
//	private String productReview;
//	
//	// @ 맵핑 ManyToOne
////	@JsonIgnoreProperties({"post"})
//	@JoinColumn(name = "post_id")
//	@ManyToOne
//	private Post post;
//	
	
//	private Date writeDate;
	
}
