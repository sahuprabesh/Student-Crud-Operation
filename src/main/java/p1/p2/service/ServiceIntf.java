package p1.p2.service;

import java.util.List;

import p1.p2.domain.Dto;

public interface ServiceIntf {
	public Dto storeStudent(Dto dto);
	public Integer cutStudenet(Integer dt);
	public List<Dto> viewTable();
	public Dto reInsert(Dto dto);
}
