package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
	private final CustomerRepository repository;
	
	public List<CustomerDTO> readAll(){
		return repository.findAll()
				.stream()
				.map(ce->{
					CustomerDTO dto = new CustomerDTO();
					dto.setId(ce.getId());
					dto.setFirstName(ce.getFirstName());
					dto.setLastName(ce.getLastName());
					return dto;
				}).toList();
	}
	
	public void create(CustomerDTO dto){
		Customer entity = new Customer();
		//한번에 dto에 있는걸 entity에다가 옮겨 담음
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
	}

}
