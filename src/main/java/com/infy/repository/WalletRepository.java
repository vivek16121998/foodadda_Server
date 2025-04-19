package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infy.entity.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {
	
	
	@Query(value = "SELECT * FROM cibo.wallet where user_id=:userId",nativeQuery = true)
	List<Wallet> getUserId(@Param("userId") Integer userId);
	

}
