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
//	@Test
	void testPersist() {
		// create a couple of events...
		sessionFactory.inTransaction(session -> {
			session.persist(new Event("Our very first event!", now()));
			session.persist(new Event("A follow up event", now()));
		});
	}
	
//	@Test
	void testRead() {
		// now lets pull events from the database and list them
		sessionFactory.inTransaction(session -> {
			session.createSelectionQuery("from Event", Event.class).getResultList()
					.forEach(event -> out.println("Event (" + event.getDate() + ") : " + event.getTitle()));
		});
	}
	
//	@Test
    void testUpdate() {
        sessionFactory.inTransaction(session -> {
            // 가장 첫 번째 이벤트 조회
            Event event = session.createSelectionQuery("from Event", Event.class)
                                 .setMaxResults(1)
                                 .getSingleResult();
            out.println("Before update: " + event.getTitle());
            // 제목 변경
            event.setTitle("Updated Title");
            // 트랜잭션 커밋 시점에 변경사항이 자동 flush 되어 반영됩니다
        });
    }

   @Test
    void testDelete() {
        sessionFactory.inTransaction(session -> {
            // 가장 첫 번째 이벤트 조회
            Event event = session.createSelectionQuery("from Event", Event.class)
                                 .setMaxResults(1)
                                 .getSingleResult();
            out.println("Deleting event: " + event.getTitle());
            session.remove(event);
        });
    }

}
