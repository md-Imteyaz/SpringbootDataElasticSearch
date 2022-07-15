package com.SpringdataElasticSearch.model;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "eindex", indexStoreType = "BankCustomer", shards = 2)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BankCustomer {
	@Id
	private long id;
	private String firstName;
	private String lastName;
	private int age;

}
