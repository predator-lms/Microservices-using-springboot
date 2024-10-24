package com.oracle.shared_database_pattern;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharedDatabasePatternApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SharedDatabasePatternApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(SharedDatabasePatternApplication.class);

	@Autowired
	private BookRepository repository;

	@Override
	public void run(String... args) throws Exception {
		log.info("DB pattern application started...");
		repository.save(new Book("Java"));
		repository.save(new Book("Python"));
		repository.save(new Book("R"));
		repository.save(new Book("Golang"));
		repository.save(new Book("Rust"));

		System.out.println("Printing all records...");
		repository.findAll().forEach(book -> System.out.println(book));

		System.out.println("Printing records by Id...");
		repository.findById(2L).ifPresent(x -> System.out.println(x));

		System.out.println("Printing records by name...");
		repository.findByName("Java").forEach(x -> System.out.println(x));

		// -------------------------------------------------------------------
/*
		System.out.println("Deleting by Book ID... ");
		Book bookToDelete = repository.findById(106L).get();
		System.out.println("Book to delete : " + bookToDelete.getName());
		repository.delete(bookToDelete);

		System.out.println("Deleting by Book ID...");
		repository.deleteById(155L);

		System.out.println("Deleting Book by title...");
		repository.findByName("Java").forEach(book -> {
			System.out.println("Deleting Book : " + book.getName());
			repository.delete(book);
		});

		System.out.println("\n Delete all by Book ID ");
		repository.deleteAllById(Arrays.asList(52L, 54L, 56L));
		System.out.println("\n Delete By NameD ");
		repository.deleteAll(repository.findByName("Javascript"));
*/
		// ---------------------------------------------------------------------------------

		System.out.println("Updating Records...");

		repository.findById(153L).ifPresent(x -> {
			System.out.println(x);
			x.setName("Adversarial Robustness Toolbox");
			repository.save(x);
		});
	}

}
