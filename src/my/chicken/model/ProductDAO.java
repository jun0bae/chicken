package my.chicken.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;



public class ProductDAO {
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
	
	public int insertProd(MultipartRequest mr) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "insert into prod values(prod_no.nextval,?,?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			ps.setString(2, mr.getParameter("pcate"));
			ps.setString(3, mr.getFilesystemName("pimage"));
			ps.setString(4, mr.getParameter("launch_date"));
			ps.setInt(5, Integer.parseInt(mr.getParameter("price")));
			ps.setString(6, mr.getParameter("coment"));
			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<ProductDTO> listProduct() throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from prod";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<ProductDTO> makeList(ResultSet rs) throws SQLException {
		List<ProductDTO> list = new ArrayList<>();
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setPnum(rs.getInt("pnum"));
			dto.setPname(rs.getString("pname"));
			dto.setPcate(rs.getString("pcate"));
			dto.setPimage(rs.getString("pimage"));
			dto.setLaunch_date(rs.getString("launch_date"));
			dto.setPrice(rs.getInt("price"));
			dto.setComent(rs.getString("coment"));
			dto.setReg_date(rs.getString("reg_date"));
			list.add(dto);
		}
		return list;
	}
	
	public ProductDTO getProduct(int pnum) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from prod where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list.get(0);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	public List<ProductDTO> getCateProd(String pcate) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from prod where pcate=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pcate);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deleteProduct(int pnum) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "delete from prod where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int editProd(MultipartRequest mr) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "update product set pname=?, pcompany=?, "
					+ "pimage=?, pqty=?, price=?, pspec=?, pcontents=?, point=? where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			ps.setString(2, mr.getParameter("pcompany"));
			String pimage = mr.getFilesystemName("pimage");
			if (pimage == null) {
				pimage = mr.getParameter("pimage2");
			}
			ps.setString(3, pimage);
			ps.setInt(4, Integer.parseInt(mr.getParameter("pqty")));
			ps.setInt(5, Integer.parseInt(mr.getParameter("price")));
			ps.setString(6, mr.getParameter("pspec"));
			ps.setString(7, mr.getParameter("pcontents"));
			ps.setInt(8, Integer.parseInt(mr.getParameter("point")));
			ps.setInt(9, Integer.parseInt(mr.getParameter("pnum")));
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}