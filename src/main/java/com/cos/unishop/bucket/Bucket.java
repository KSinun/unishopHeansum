package com.cos.unishop.bucket;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cos.unishop.domain.user.User;

import lombok.Data;

@Data
@Entity
public class Bucket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
		
	@OneToMany
	@JoinColumn(name="bucket_id")
	private List<BucketProducts> products;
	
}
