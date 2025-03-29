package com.restapi.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.restapi.entity.Visitor;
import com.restapi.repository.VisitorRepository;
import com.restapi.service.VisitorService;

@Service
public class VisitorServiceImplemenation implements VisitorService{

	private VisitorRepository visitorRepository;
	public VisitorServiceImplemenation(VisitorRepository visitorRepository) {
		super();
		this.visitorRepository = visitorRepository;
	}

	@Override
	public Visitor saveVisitor(Visitor visitor) {
		String randomUserId = UUID.randomUUID().toString();
		visitor.setId(randomUserId);
		return this.visitorRepository.save(visitor);
	}

	@Override
	public Visitor updateVisitor(Visitor visitor) {
		Optional<Visitor> v = this.visitorRepository.findById(visitor.getId());
		if(v.isPresent()) {
			return this.visitorRepository.save(visitor);
		}else {
			return null;
		}
	}

	@Override
	public List<Visitor> showAllVisitors() {
		return this.visitorRepository.findAll();
	}

	@Override
	public void deleteVisitor(String id) {
		this.visitorRepository.deleteById(id);
	}

	@Override
	public Visitor getVisitorById(String id) {
		Optional<Visitor> v = this.visitorRepository.findById(id);
		if(v.isPresent()) {
			return v.get();
		}else {
			return null;
		}
	}

	@Override
	public List<Visitor> getVisitorBySex(String sex) {
		return this.visitorRepository.findBySex(sex);
	}

}
