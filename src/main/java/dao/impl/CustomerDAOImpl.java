package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dao.ICustomerDAO;
import vo.Customer;

public class CustomerDAOImpl implements ICustomerDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	public CustomerDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Customer vo) throws Exception {
		String sql = "INSERT INTO customer(id,name,gender,phone,email, description)VALUES(?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getId());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getGender());
		this.pstmt.setString(4, vo.getPhone());
		this.pstmt.setString(5, vo.getEmail());
		this.pstmt.setString(6, vo.getDescription());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Customer vo) throws Exception {
		String sql = "UPDATE customer SET name = ? ,gender=?,phone=?,email=?,description=? WHERE id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setString(2, vo.getGender());
		this.pstmt.setString(3, vo.getPhone());
		this.pstmt.setString(4, vo.getEmail());
		this.pstmt.setString(5, vo.getDescription());
		this.pstmt.setInt(6, vo.getId());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		if (ids == null || ids.size() == 0) {
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM customer WHERE id IN(");
		Iterator<Integer> iter = ids.iterator();
		while (iter.hasNext()) {
			sql.append(iter.next()).append(",");
		}
		sql.delete(sql.length() - 1, sql.length()).append(")");
		this.pstmt = this.conn.prepareStatement(sql.toString());
		return this.pstmt.executeUpdate() == ids.size();
	}

	@Override
	public Customer findById(Integer id) throws Exception {
		Customer vo = null;
		String sql = "SELECT id ,name,gender,phone,email,description FROM customer WHERE id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Customer();
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setGender(rs.getString(3));
			vo.setPhone(rs.getString(4));
			vo.setEmail(rs.getString(5));
			vo.setDescription(rs.getString(6));
		}
		return vo;
	}

	@Override
	public List<Customer> findAll() throws Exception {
		List<Customer> all = new ArrayList<Customer>();
		String sql = "SELECT id,name,gender,phone,email,description FROM customer";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Customer vo = new Customer();
			vo = new Customer();
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setGender(rs.getString(3));
			vo.setPhone(rs.getString(4));
			vo.setEmail(rs.getString(5));
			vo.setDescription(rs.getString(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Customer> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		List<Customer> all = new ArrayList<Customer>();
		String sql = "SELECT id,name,gender,phone,email,description FROM customer";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Customer vo = new Customer();
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setGender(rs.getString(3));
			vo.setPhone(rs.getString(4));
			vo.setEmail(rs.getString(5));
			vo.setDescription(rs.getString(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		String sql = "SELECT COUNT(id) FROM customer WHERE" + column + "Like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}

}
