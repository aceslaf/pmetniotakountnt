package org.gjoko.javabrains;

import org.gjoko.javabrains.dao.NamedParameterJdbcTemplateImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbcDemo {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		NamedParameterJdbcTemplateImpl dao = context.getBean("namedParameterJdbcTemplateImpl", NamedParameterJdbcTemplateImpl.class);
		//Circle circle = dao.getCircle(1);
		//System.out.println(circle.getName());
		
		
		/*dao.insertCircle(new Circle(2, "Second circle"));
		
		System.out.println(dao.getCircleCount());
		//System.out.println(dao.getCircleForId(1).getId() + " " + dao.getCircleForId(1).getName());*/
		
		
		//dao.insertCircleUsingNameParameters(new Circle(4, "Fourth circle"));
		
		System.out.println(dao.getCircleCount());
		
		//dao.createTriangleTable();
	}
}
