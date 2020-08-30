package com.g.hazelcast.repository;

import com.g.hazelcast.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
