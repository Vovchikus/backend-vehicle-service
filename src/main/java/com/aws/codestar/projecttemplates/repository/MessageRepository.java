package com.aws.codestar.projecttemplates.repository;

import com.aws.codestar.projecttemplates.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
