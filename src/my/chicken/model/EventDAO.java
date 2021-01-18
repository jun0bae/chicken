package my.chicken.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

public class EventDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static DataSource ds;		
	static {
		try {
			Context init = new InitialContext();	
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e) {
			System.err.println("lookup ½ÇÆÐ : " + e.getMessage());
		}
	}
	public List<EventDTO> listEvent() throws SQLException{
		try {
			con = ds.getConnection();
			String sql = "select * from event";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<EventDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<EventDTO> makeList(ResultSet rs) throws SQLException {
		List<EventDTO> list = new ArrayList<>();
		while(rs.next()) {
			EventDTO dto = new EventDTO();
			dto.setNum(rs.getInt("num"));
			dto.setEname(rs.getString("ename"));
			dto.setEimage(rs.getString("eimage"));
			dto.setEstart(rs.getString("estart"));
			dto.setEend(rs.getString("eend"));
			dto.setEtype(rs.getString("etype"));
			dto.setReadcount(rs.getString("readcount"));
			dto.setReg_date(rs.getString("reg_date"));
			list.add(dto);
		}
		return list;
	}
	
	public int insertEvent(MultipartRequest mr) throws SQLException {
		
		try {
			con = ds.getConnection();
			String sql = "insert into event values(event_num.nextval,?,?,?,?,?,0,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, mr.getParameter("ename"));
			ps.setString(2, mr.getParameter("eimage"));
			ps.setString(3, mr.getParameter("estart"));
			ps.setString(4, mr.getParameter("eend"));
			ps.setString(5, mr.getParameter("etype"));
			int res = ps.executeUpdate(); 
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	public List<EventDTO> getEvent(String event) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from event where = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,event);
			rs = ps.executeQuery();
			List<EventDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	 
	}

	
}