package com.momo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.momo.vo.Member;

@Component
public class MemberDao {
	
	public Member login(Member paramMember) {
		Member member = null;
		
		String sql = 
				String.format("select id, name, adminyn, grade from member "
				+ "where id='%s' and pw='%s'", paramMember.getId(), paramMember.getPw());
		
		try (Connection conn = ConnectionUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			// 질의결과 결과집합을 member객체에 담아줍니다
			if(rs.next()) {
				String name = rs.getString(2);
				String adminYN = rs.getString(3);
				String grade = rs.getString(4);
				
				member = new Member();
				member.setId(paramMember.getId());
				member.setName(name);
			}
			System.out.println("member:"+member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
}
