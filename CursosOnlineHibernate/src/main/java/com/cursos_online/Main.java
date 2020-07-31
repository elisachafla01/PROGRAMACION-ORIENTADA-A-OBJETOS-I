package com.cursos_online;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import com.cursos_online.entidades.Curso;
import com.cursos_online.entidades.Estudiantes;

public class Main {
	
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory= (SessionFactory) new MetadataSources(registry).buildMetadata();
	

	public static void main(String[] args) {
		Curso cur1 = new Curso("fundamentos d java");
		Curso cur2 = new Curso("hibernate para principiantes");
		
		ingresarCurso(cur1);
		ingresarCurso(cur2);
		
		Estudiantes estd1 = new Estudiantes(0,"cesar","alcivar");
		Estudiantes estd2 = new Estudiantes(0,"leonela","vera");
		
		ingresarEstudiante(estd1);
		ingresarEstudiante(estd2);
	}
	
	static void ingresarEstudiante(Estudiantes estudiante) {
		Session sessio= sessionFactory.openSession();
		sessio.beginTransaction();
		sessio.save(estudiante);
		
		sessio.getTransaction().commit();
		sessio.close();
	}
		
	static void ingresarCurso(Curso curso) {
		Session sessio= sessionFactory.openSession();
		sessio.beginTransaction();
		sessio.save(curso);
		
		sessio.getTransaction().commit();
		sessio.close();
		
		
		/*final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Curso curso = new Curso("Nuevo Curso");
		session.save(curso);
		
		session.getTransaction().commit();
		*/
	}

}
