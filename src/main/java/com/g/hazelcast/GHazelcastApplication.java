package com.g.hazelcast;

import com.g.hazelcast.domain.Person;
import com.g.hazelcast.repository.HPersonRepository;
import com.g.hazelcast.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GHazelcastApplication implements CommandLineRunner {

	private final static Logger LOGGER = LoggerFactory.getLogger(GHazelcastApplication.class);

	@Autowired
	private HPersonRepository hPersonRepository;

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(GHazelcastApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person(1, "Santhosh");
//		personStore.store(String.valueOf(person.getId()), person);
		hPersonRepository.save(person);
		new Thread(){
			@Override
			public void run() {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					LOGGER.error("Exception when sleep ", e);
				}
				LOGGER.info("Data got from h2 : "+personRepository.findAll());
			}
		}.start();
	}
}
