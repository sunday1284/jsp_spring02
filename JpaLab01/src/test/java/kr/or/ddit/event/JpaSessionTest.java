package kr.or.ddit.event;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.event.entity.Event;
// 스테틱으로 바로 불러와서 now를 쓸 수 있음
import static java.time.LocalDateTime.*;
import static java.lang.System.*;


class JpaSessionTest {

	private static SessionFactory sessionFactory;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		final StandardServiceRegistry registry =
				new StandardServiceRegistryBuilder()
						.build();
		try {
			sessionFactory =
					new MetadataSources(registry)
							.addAnnotatedClass(Event.class)
							.buildMetadata()
							.buildSessionFactory();
		}
		catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we
			// had trouble building the SessionFactory so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	@Test
	void testPersist() {
		// create a couple of events...
		sessionFactory.inTransaction(session -> {
			Event event1 = new Event("Our very first event!", now()); //트랜지헌트 상태 
			session.persist(event1);
			event1.setTitle("수정제목1");
			Event event2 = new Event("A follow up event", now());
			session.persist(event2);
			//detach 다시 빼냄
//			session.detach(event2);
			event2.setTitle("수정제목2");
		});
	}
	
	@Test
	void testRead() {
		// now lets pull events from the database and list them
		sessionFactory.inSession(session -> { // 트랜잭션 없는 상태에서 쿼리 실행
			session.createSelectionQuery("from Event", Event.class).getResultList() // jpql 
					.forEach(event -> out.println("Event (" + event.getDate() + ") : " + event.getTitle()));
		});
	}
	

}
