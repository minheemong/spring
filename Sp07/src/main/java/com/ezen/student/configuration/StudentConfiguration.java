package com.ezen.student.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ezen.student.dao.StudentDao;
import com.ezen.student.dto.DataBaseConnectionInfo;
import com.ezen.student.service.InsertService;
import com.ezen.student.service.SelectAllService;
import com.ezen.student.service.SelectOneService;
import com.ezen.student.service.UpdateService;

@Configuration // @는 명찰 같은 것
public class StudentConfiguration {
	
	// Configuration 이라는 어너테이션이 붙은 클래스를 이용해서, 활용가능한 클래스의
	// 객체를 직접 생성 리턴해주는 메서드를 제작 운영합니다.
	
	@Bean
	public DataBaseConnectionInfo dbConnectionInfo() {
		// DataBaseConnectionInfo 형태의 new 인스턴스를 만들고 리턴해주는 메서드
		DataBaseConnectionInfo temp = new DataBaseConnectionInfo();
		temp.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		temp.setUserId("scott");
		temp.setUserPw("tiger");
		temp.setDriver("oracle.jdbc.driver.OracleDriver");
		return temp;
	} // Bean 어너테이션이 붙은 메서드는 해당 객체가 리턴되는 객체들이며, 함수를 직접 이름으로
	// 호출하지 않고, getBean() 메서드를 이용하여 객체를 리턴받게 환경을 구성해 줍니다.
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDao(dbConnectionInfo());
	}
	
	public SelectAllService selectAllService() {
		return new SelectAllService(studentDao());
	}
	public SelectOneService selectOneService() {
		return new SelectOneService(studentDao());
	}
	public	UpdateService pdateService() {
		return new UpdateService(studentDao());
	}
	public InsertService insertService() {
		return new InsertService(studentDao());
	}
}
