package com.g.hazelcast.repository;

import com.g.hazelcast.domain.Person;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface HPersonRepository extends KeyValueRepository<Person, Integer> {
}
