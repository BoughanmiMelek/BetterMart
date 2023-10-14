package com.PIDEV.demo.Repositories;

import com.PIDEV.demo.Entities.Claim;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRep extends CrudRepository<Claim,Integer> {
}
