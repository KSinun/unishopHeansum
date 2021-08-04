package com.cos.unishop.bucket;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.unishop.domain.post.Post;
import com.cos.unishop.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Bucket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnoreProperties("user")
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
		
	@JsonIgnoreProperties("products")
	@ManyToOne
	@JoinColumn(name="product_id")
	private Post products;
	
	private int count;
	private int totalPayment;
}
