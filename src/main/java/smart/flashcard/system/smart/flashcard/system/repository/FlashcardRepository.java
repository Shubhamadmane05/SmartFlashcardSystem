package smart.flashcard.system.smart.flashcard.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.flashcard.system.smart.flashcard.system.model.Flashcard;
import java.util.List;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    List<Flashcard> findByStudentId(String studentId);
}

