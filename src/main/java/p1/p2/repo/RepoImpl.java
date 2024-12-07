package p1.p2.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import p1.p2.domain.Dto;

@Repository
public class RepoImpl implements RepoIntf {

	@Autowired
	public DataSource datasource;

	private Connection getCon() {
		Connection con = null;
		try {
			con = datasource.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;

	}

	private void closeCon(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Dto insertStudent(Dto dto) {


		System.out.println(dto.getAddr());
		System.out.println(dto.getName());
		Connection con = null;
		PreparedStatement prepareState = null;
		int res = 0;
		try {
			con = getCon();
			
			String query = "insert into student(sid,sname,saddr,sfee) values(?,?,?,?)";
			prepareState = con.prepareStatement(query);

			prepareState.setInt(1, dto.getId());
			prepareState.setString(2, dto.getName());
			prepareState.setString(3, dto.getAddr());
			prepareState.setDouble(4, dto.getFee());

			res = prepareState.executeUpdate();

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeCon(con);
		}
		if (res == 1) {
			return dto;
		} else {
			return null;
		}

	}

	public int deleteStudent(Integer sid) {
		Connection con = null;
		int res = 0;
		PreparedStatement preparestate;
		try {
			con = getCon();
			String query = "delete from student where sid=?";

			preparestate = con.prepareStatement(query);
			preparestate.setInt(1, sid);

			res = preparestate.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeCon(con);
		}
		return res;
	}
	
	public ResultSet tableData()
	{
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		try
		{
			System.out.println("Enter into Repository Layer");
			con=getCon();
			String query="select * from student";
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			System.out.println(rs);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} /*
			 * finally { closeCon(con); }
			 */
		return rs;
	}
	
	public Dto updateData(Dto dt)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int res=0;
		try
		{
			con=getCon();
			String query="update student set sname=?,saddr=?,sfee=? where sid=?";
			ps=con.prepareStatement(query);
			ps.setString(1,dt.getName());
			ps.setString(2,dt.getAddr());
			ps.setDouble(3,dt.getFee());
			ps.setInt(4,dt.getId());
			
			res=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally { 
			closeCon(con);
		}
		if(res==1)
		{
			return dt;
		}
		else
		{
			return null;
		}
	}
}
