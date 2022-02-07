package com.ezen.sp03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		WalkClass wco = new WalkClass();
		wco.move();
		
		// 스프링 프레임워크에서는 클래스의 운용방식이 위와 같이 ㅇ낳고, 정의된 클래스의  new 인스턴스를
		// 시작과 함께 미리 만들어서 필요할때 꺼내쓰는 방식으로 사용합니다
		
		// 만들어진 인스턴스의 보관장소를 스프링 컨테이너 라고 부릅니다.
		// 현재 사용할 스프링 컨테이너는 applicationContext.xml  입니다.
		
		// 스프링 컨테이너에 담겨 있는 객체들을   Bean 이라고 부릅니다.
		// 스프링 컨테이너에 담겨 있는 빈을 필요할때 꺼내 쓰려면 아래와 같이 컨테이너의 사용권한을 갖고 있는
		// 객체를 생성하여 사용합니다		
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// applicationContext.xml : 스프링 컨테이너 역할을 하는  resources  폴더안의 파일이름.
			
		// 레퍼런스 변수를 선언하고, 스프링컨테이너에서 객체를 꺼내서 선언된 레퍼런스 변수에 저장합니다
		WalkClass wc = ctx.getBean("cWalk", WalkClass.class);
		// 빈을 꺼내서 저장할 레퍼런스 변수는 기존과 같이 선언하며, 주소값은   getBean() 메서드가
		// 전달하여 저장합니다
		// cWalk : 스프링 컨테이너 내부에 있는 그 클래스의 id 값
		// WalkClass.class ; 스프링 컨테이너 내부에 있는 그 클래스의 이름
		
		wc.move();
		ctx.close();
		
		// 아직까지 일반 자바 프로젝트에서 사용하는 new WalkClass() 와 사용상 차이점은 없어 보입니다.
		// 차이점을 궂이 써본다면, new 인스턴스를 사용하면 사용할때마다 새로운 인스턴스가 생성되는 반면
		// getBean() 은 싱글턴 방식처럼 하나의 생성된 객체가 계속 사용된다는 점이 다릅니다
		// getBean() 으로 같은 클래스의 서로 다른 인스턴스를 두개 사용해야 한다면, 다른 id  값으로 Bean을
		// 두개 추가하여 사용합니다.
		// <bean class="com.ezen.spcon.WalkClass" id="cWalk2"></bean>
	}

}
