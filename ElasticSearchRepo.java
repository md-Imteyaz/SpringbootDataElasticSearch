package com.SpringdataElasticSearch.Repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.SpringdataElasticSearch.model.BankCustomer;

@Repository
@Component
public interface ElasticSearchRepo extends ElasticsearchRepository<BankCustomer, Long> {

	List<BankCustomer> findByfirstName(String firstName);

	BankCustomer deleteid(long id);

}
