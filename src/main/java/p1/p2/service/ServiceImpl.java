package p1.p2.service;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import p1.p2.domain.Dto;
import p1.p2.repo.RepoIntf;

@Service
public class ServiceImpl implements ServiceIntf {
	
	@Autowired
	private RepoIntf repository;
	
	Dto dto=null;

	@Override
	public Dto storeStudent(Dto dto) {
		System.out.println("Service Enter");
		
		Dto dataOfRepo=repository.insertStudent(dto);
		
		System.out.println(dto.getAddr());
		System.out.println(dto.getName());
		if(dataOfRepo!=null)
		{
			return dataOfRepo;
		}
		else
		{
			return null;
		}
		
	}

	public Integer cutStudenet(Integer dt) {
		
		System.out.println("service deleted"+dt);
		int cutStudent=repository.deleteStudent(dt);
		
		if(cutStudent==1)
		{
			System.out.println("One Student Detail Deleted");
		}
		else
		{
			System.out.println("Not Deleted");
		}
		return cutStudent;
		
	}
	
	public List<Dto> viewTable()
	{
		List<Dto> stdList=new ArrayList<>();
		
		try {
			ResultSet rs=repository.tableData();
			System.out.println("Enter into service");
			while(rs.next())
			{
				Dto dt=new Dto();
				dt.setId(rs.getInt(1));
				dt.setName(rs.getString(2));
				dt.setAddr(rs.getString(3));
				dt.setFee(rs.getDouble(4));
				stdList.add(dt);
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+"In service layer");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stdList;
	}
	
	public Dto reInsert(Dto dto)
	{
		Dto result=repository.updateData(dto);
		if(result!=null)
		{
			System.out.println("Record Updated");
			return result;
		}
		else
		{
			System.out.println("Record did not Updeted successful");
			return null;
		}
	}
	

}
