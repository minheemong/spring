package com.ezen.student.service;

import java.util.ArrayList;

import com.ezen.student.dao.StudentDao;
import com.ezen.student.dto.Student;

public class SelectOneService {
	
	private StudentDao sdao;
	
	public SelectOneService( StudentDao sdao ) {
		this.sdao = sdao;
	}
	
	public Student selectOnerStudent( String sNum ) {
		Student std = sdao.selectOneStudent( sNum );
		return std;
	}
}
