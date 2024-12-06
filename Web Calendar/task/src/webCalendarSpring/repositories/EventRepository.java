package webCalendarSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webCalendarSpring.domain.Event;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByDate(LocalDate now);

    List<Event> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
