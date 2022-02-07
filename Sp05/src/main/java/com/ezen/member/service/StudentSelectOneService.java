package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentSelectOneService {

private StudentDao sdao;
	
	public StudentSelectOneService( StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public Student selectOneStudent( String sNum ) {
		//Student std = sdao.selectOneStudent(sNum);
		//return std;
		return sdao.selectOneStudent(sNum);
	}
	
}
