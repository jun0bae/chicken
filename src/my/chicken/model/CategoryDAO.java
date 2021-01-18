package my.chicken.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CategoryDAO {
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
	
	public List<CategoryDTO> listCate() throws SQLException{
		try {
			con = ds.getConnection();
			String sql = "select * from cate";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<CategoryDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	protected List<CategoryDTO> makeList(ResultSet rs) throws SQLException{
		List<CategoryDTO> list = new ArrayList<>();
		while(rs.next()) {
			CategoryDTO dto = new CategoryDTO();
			dto.setCnum(rs.getInt("cnum"));
			dto.setCname(rs.getString("cname"));
			list.add(dto);
		}
		return list;
	}
	
	public int insertCate(CategoryDTO dto) throws SQLException{
			try {
				con = ds.getConnection();
				String sql = "insert into cate values(cate_no.nextval,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getCname());
				int res = ps.executeUpdate();
				return res;
			}finally {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}
		}
	
	public int deleteCate(int cnum) throws SQLException{
		try {
			con = ds.getConnection();
			String sql = "delete from cate where cnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cnum);
			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public String getCategoryName(String code) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select cname from category where code = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}
