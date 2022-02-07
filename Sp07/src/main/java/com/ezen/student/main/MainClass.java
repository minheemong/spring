package com.ezen.student.main;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.student.dto.EMSInformationService;
import com.ezen.student.dto.Student;
import com.ezen.student.service.InsertService;
import com.ezen.student.service.SelectAllService;
import com.ezen.student.service.SelectOneService;
import com.ezen.student.service.UpdateService;

public class MainClass {
	public static void main(String[] args) {
		
		//[3개의 appCtx에서 가져올 예정]
		// GenericXmlApplicationContext ctx 
		// = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		/* 1. 배열에서 여러 개의 xml을 가져오는 방법
		 * String[] appCtxs = {"classpath:appCtx01.xml", "classpath:appCtx02.xml",
		 * "classpath:appCtx03.xml"}; GenericXmlApplicationContext ctx = new
		 * GenericXmlApplicationContext(appCtxs);
		 */
		
		//2. import한 xml을 방법
		GenericXmlApplicationContext ctx = new
		GenericXmlApplicationContext("classpath:appCtx_Import.xml");
		
		
		
		
		
		InsertService is	= ctx.getBean("insertService", InsertService.class);
		// is 로  insert
		SelectAllService sas	= ctx.getBean("selectAllService", SelectAllService.class);
		// sas 로 모두 조회
		ArrayList<Student> list = sas.selectAllStudent();
		for(int j=0; j<list.size(); j++) {
			System.out.print("| sNum : " + list.get(j).getsNum() + "\t");
			System.out.print("| sId : " + list.get(j).getsId() + "\t");
			System.out.print("| sPw : " + list.get(j).getsPw() + "\t");
			System.out.print("| sName :" + list.get(j).getsName() + "\t");
			System.out.print("| sAge : " + list.get(j).getsAge() + "\t");
			System.out.print("| sGender : " + list.get(j).getsGender() + "\t");
			System.out.print("| sMajor : " + list.get(j).getsMajor() + "\n");
		}
		
		
		UpdateService us	= ctx.getBean("updateService", UpdateService.class);
		// us 로 수정
		SelectOneService sos	= ctx.getBean("selectOneService", SelectOneService.class);
		// sos 로 한명검색
		
		EMSInformationService eis
		= ctx.getBean("informationService", EMSInformationService.class);
		eis.outputEMSInformation();
		
		ctx.close();
	}
}
