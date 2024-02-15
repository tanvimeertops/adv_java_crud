package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;
import com.util.StudentUtil;

public class StudentDao {
public static void insertStudent(Student s) {
	try {
	Connection conn=StudentUtil.createConnection();
	String sql="insert into student1(fname,lname,email,mobile,address,gender)values(?,?,?,?,?,?)";
	
		
			PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getMobile());
			pst.setString(5, s.getAddress());
			pst.setString(6, s.getGender());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

public static List<Student> getAllStudents() throws SQLException {
	List<Student> list=new ArrayList<Student>();
	Connection conn=StudentUtil.createConnection();
	String sql="select * from student1";
	
	PreparedStatement pst=conn.prepareStatement(sql);
	ResultSet rs= pst.executeQuery();
	
	while (rs.next()) {
		Student s=new Student();
		s.setId(rs.getInt("id"));
		s.setFname(rs.getString("fname"));
		s.setLname(rs.getString("lname"));
		s.setEmail(rs.getString("email"));
		s.setMobile(rs.getString("mobile"));
		s.setAddress(rs.getString("address"));
		s.setGender(rs.getString("gender"));
		list.add(s);
	}
	
	
	return list;
}

public static Student getAllStudentById(int id)
		throws SQLException {
	Student s=new Student();
	Connection conn=StudentUtil.createConnection();
	String sql="select * from student1 where id=?";
	
	PreparedStatement pst=conn.prepareStatement(sql);
	pst.setInt(1, id);
	ResultSet rs= pst.executeQuery();
	
	if (rs.next()) {
		s.setId(rs.getInt("id"));
		s.setFname(rs.getString("fname"));
		s.setLname(rs.getString("lname"));
		s.setEmail(rs.getString("email"));
		s.setMobile(rs.getString("mobile"));
		s.setAddress(rs.getString("address"));
		s.setGender(rs.getString("gender"));
	}
	
	
	return s;
}

public static void updateStudent(Student s) {
	try {
	Connection conn=StudentUtil.createConnection();
	String sql="update student1 set fname=?,lname=?,email=?"
			+ ",mobile=?,address=?,gender=? where id=?";
	
		
			PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getMobile());
			pst.setString(5, s.getAddress());
			pst.setString(6, s.getGender());
			pst.setInt(7, s.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
public static Student deleteStudentById(int id)
		throws SQLException {
	Student s=new Student();
	Connection conn=StudentUtil.createConnection();
	String sql="delete from student1 where id=?";
	
	PreparedStatement pst=conn.prepareStatement(sql);
	pst.setInt(1, id);
	pst.executeUpdate();
	return s;
}
}
