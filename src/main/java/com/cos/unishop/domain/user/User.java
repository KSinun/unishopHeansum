package com.cos.unishop.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.cos.unishop.bucket.Bucket;
import com.cos.unishop.bucket.BucketProducts;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;// 프라이머리키

    @Column(unique = true, length = 20)
    private String username;
    private String password;
    private String email;
    private String address;
    private String phonenumber; 

    //
//    
//    @OneToOne
//    @JoinColumn(name="bucket")
//    private BucketProducts userBucket;
    @ManyToOne
    @JoinColumn(name="bucket_id")
    private Bucket bucket;
    
}
