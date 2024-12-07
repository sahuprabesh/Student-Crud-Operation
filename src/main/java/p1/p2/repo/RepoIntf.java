package p1.p2.repo;

import java.sql.ResultSet;

import p1.p2.domain.Dto;

public interface RepoIntf {

	public Dto insertStudent(Dto dto);
	public int deleteStudent(Integer dto);
	public ResultSet tableData();
	public Dto updateData(Dto dt);
}
