package com.bigdate2017.questbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bigdate2017.questbook.vo.QuestBookVo;

public class QuestBookDao {

	public List<QuestBookVo> getList() {
		List<QuestBookVo> list = new ArrayList<QuestBookVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL문 실행
			String sql = 
				   	  " select no, name, content, to_char(reg_day, 'yyyy-mm-dd hh:mi:ss') "
					+ " from questbook "
					+ " order by reg_day desc";
			rs = stmt.executeQuery(sql);
			
			// 결과 가져오기(사용하기)
			while( rs.next() ) {
				Long no = rs.getLong( 1 );
				String name = rs.getString( 2 );
				String content = rs.getString( 3 );
				String reg_day = rs.getString( 4 );
				
				
				QuestBookVo vo = new QuestBookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setContent(content);
				vo.setReg_day(reg_day);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			// 자원 정리
			try {
				if( rs != null ) {
					rs.close();
				}
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return list;
	}
	
	
	public int insert(QuestBookVo vo) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			// Statement 준비
			String sql = 
					" insert into questbook"+
					" values(seq_questbook.nextval, ?, ?, ?, sysdate) ";
			pstmt = conn.prepareStatement( sql );
			
			// binding
			//값넣고 업데이트해
			pstmt.setString( 1, vo.getName() );
			pstmt.setString( 2, vo.getPassword() );
			pstmt.setString(3, vo.getContent());
			
			// SQL문 실행
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			// 자원 정리
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return count;
	}
	
	public int delete(QuestBookVo vo) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			// Statement 객체 생성
			
			// SQL문 실행
			String sql = "delete from questbook" + 
					" where no = ?" +
					" and password = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong( 1, vo.getNo() );
			pstmt.setString( 2, vo.getPassword() );
			
			
			count = pstmt.executeUpdate();
			

		} catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			// 자원 정리
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}
	
	
	private Connection getConnection() throws SQLException {

		Connection conn = null;
		
		try {
			// JDBC 드라이버 로딩(JDBC 클래스 로딩)
			Class.forName( "oracle.jdbc.driver.OracleDriver" );

			// Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection( url, "webdb", "webdb" );
		
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		}
		
		return conn;
	}
}