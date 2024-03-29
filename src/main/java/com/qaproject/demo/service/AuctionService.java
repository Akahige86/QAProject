package com.qaproject.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qaproject.demo.auctions.Auction;
import com.qaproject.demo.auctions.Bid;
import com.qaproject.demo.clients.Consumer;
import com.qaproject.demo.exceptions.NoAuctionFound;
import com.qaproject.demo.exceptions.NoClientFound;
import com.qaproject.demo.filters.Filters;
import com.qaproject.demo.repositories.AuctionRepo;
import com.qaproject.demo.repositories.ConsumerRepo;
import com.qaproject.demo.repositories.ProfessionalRepo;

@Service
public class AuctionService {
	
	private AuctionRepo ar;
	private ConsumerRepo cr;
	private ProfessionalRepo pr;
	private BidService bs;
	
	@Autowired
	public AuctionService(AuctionRepo ar, ConsumerRepo cr, ProfessionalRepo pr, BidService bs) {
		this.ar = ar;
		this.cr = cr;
		this.pr = pr;
		this.bs = bs;
	}
	
	public Auction createAuction(String customerId, Auction newAuction) {
		Consumer clientFound = Optional.ofNullable(this.cr.getConsumerById(customerId)).orElseThrow(() -> new NoClientFound("There are no such Client, to create an Auction"));
		System.out.println("Clinet Found" + clientFound.getFullName());
		newAuction.setWhoCreated(clientFound);
		System.out.println(newAuction.getWhoCreated());
		return Optional.of(this.ar.save(newAuction)).orElseThrow(() -> new NoAuctionFound("Could not create an auction"));
	}
	
	public List<Auction> getAuctions(String clientId) {
		return Optional.of(this.ar.findAllAuctionByWhoCreated(clientId)).get();
	}
	
	//method to delete auction form Auction Table, together with Bids
	public Boolean deleteAuction(Integer id) {
		if(Optional.ofNullable(this.ar.findById(id)).isPresent()) {
			System.out.println("deleting auction started and present");
			List<Bid> bidList = this.bs.getBidsByAuctionId(id);
			if(bidList.size() > 0) this.bs.getBidsByAuctionId(id).forEach(bid -> this.bs.deleteBid(bid.getId()));
			this.ar.deleteById(id);
//			System.out.println(this.bs.getBidsByAuctionId(id));
			return Optional.ofNullable(this.ar.findById(id)).isEmpty();
		} return true;
		
	}
	
	public List<Auction> getAuctionFiltered(String professionalId, Filters body) {
		Optional.ofNullable(this.pr.getProfessionalById(professionalId)).orElseThrow();
		
		List<Auction> auctions = this.ar.findAll()
				.stream()
//				.filter(auction -> auction.getVolume() > body.getVolume())
				.collect(Collectors.toList());
		
		return auctions;
	}
	
}
