package com.cos.unishop.bucket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BucketProductsRepository extends JpaRepository<BucketProducts, Integer>{

	@Query(value = "SELECT * FROM bucket_products WHERE user_id = :id", nativeQuery = true)
	List<BucketProducts> mFindAllByProductId(int id);
}
