package my.chicken.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
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

	public List<BoardDTO> listBoard(int start, int end) throws SQLException{
		try {
			con = ds.getConnection();
			String sql = "select * from (select rownum rn, A.* from "
					+ "(select * from freeboard order by re_step asc)A) "
					+ "where rn between ? and ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<BoardDTO> makeList(ResultSet rs) throws SQLException {
		List<BoardDTO> list = new ArrayList<>();
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("fnum"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			dto.setRe_step(rs.getInt("re_step"));
			dto.setRe_level(rs.getInt("re_level"));
			list.add(dto);
		}
		return list;
	}
	
	public int insertBoard(BoardDTO dto) throws SQLException {
		String sql = null;
		if (dto.getNum() == 0) {
			sql = "update freeboard set re_step = re_step + 1";
			dto.setRe_step(0);
			dto.setRe_level(0);
		}else {
			sql = "update freeboard set re_step = re_step + 1 where re_step > " + dto.getRe_step();
			dto.setRe_step(dto.getRe_step() + 1);
			dto.setRe_level(dto.getRe_level() + 1);
		}
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			sql = "insert into freeboard values(board_num.nextval, ?,?,?,?, sysdate, 0, ?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getPasswd());
			ps.setString(5, dto.getContent());
			ps.setString(6, dto.getIp());
			ps.setInt(7, dto.getRe_step());
			ps.setInt(8, dto.getRe_level());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public BoardDTO getBoard(int num) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from freeboard where fnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			List<BoardDTO> getBoard = makeList(rs);
			return getBoard.get(0);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public void plusReadcount(int num) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "update freeboard set readcount = readcount + 1 where fnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			int res = ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	protected boolean isPassword(int num, String passwd) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select passwd from freeboard where fnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			rs.next();
			String dbPass = rs.getString(1);
			if (dbPass.trim().equals(passwd)) {
				return true;
			}else {
				return false;
			}
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deleteBoard(int num, String passwd) throws SQLException {
		boolean isPasswd = isPassword(num, passwd);
		if (!isPasswd) return -1;
		try {
			con = ds.getConnection();
			String sql = "delete from freeboard where fnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int updateBoard(BoardDTO dto) throws SQLException {
		boolean isPasswd = isPassword(dto.getNum(), dto.getPasswd());
		if (!isPasswd) return -1;
		try {
			con = ds.getConnection();
			String sql = "update freeboard set writer=?, subject=?, email=?, content=? where fnum = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getSubject());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getContent());
			ps.setInt(5, dto.getNum());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int getCount() throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select count(*) from freeboard";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}














