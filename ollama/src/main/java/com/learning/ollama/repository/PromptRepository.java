package com.learning.ollama.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learning.ollama.request.PromptRequest;

@Repository
public interface PromptRepository extends MongoRepository<PromptRequest, String> {

}
