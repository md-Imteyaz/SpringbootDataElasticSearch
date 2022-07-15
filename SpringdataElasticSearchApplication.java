package com.SpringdataElasticSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringdataElasticSearch.Repository.ElasticSearchRepo;
import com.SpringdataElasticSearch.model.BankCustomer;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class })
@SpringBootApplication
@RestController
public class SpringdataElasticSearchApplication {
	@Autowired
	ElasticSearchRepo elasticsearchrepos;

	@PostMapping("/saveAll")
	public int saveCustomer(@RequestBody List<BankCustomer> customer) {
		elasticsearchrepos.saveAll(customer);
		return customer.size();
	}

	@GetMapping("/findAll")
	public Iterable<BankCustomer> findAllCustomer(BankCustomer customer) {
		return elasticsearchrepos.findAll();
	}

	@GetMapping("/findByFirstName/{firstName}")
	public List<BankCustomer> findByFirstName(@PathVariable String firstName) {
		return elasticsearchrepos.findByfirstName(firstName);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BankCustomer> deleteId(@PathVariable("id") long id) {
		BankCustomer customer = null;
		try {
			customer = elasticsearchrepos.deleteid(id);

		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<BankCustomer>(customer, HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdataElasticSearchApplication.class, args);
	}

}
