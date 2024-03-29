package com.qaproject.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qaproject.demo.auctions.Auction;

@Repository
public interface AuctionRepo extends JpaRepository<Auction, Integer>{
	
	@Query(value = "SELECT * FROM auction WHERE F_KEY_CONSUMER_ID = ?1", nativeQuery = true)
	public List<Auction> findAllAuctionByWhoCreated(String clientId);
	
}
