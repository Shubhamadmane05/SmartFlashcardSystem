package smart.flashcard.system.smart.flashcard.system.service;



import smart.flashcard.system.smart.flashcard.system.model.Flashcard;
import smart.flashcard.system.smart.flashcard.system.repository.FlashcardRepository;

import java.util.List;

public interface FlashcardService {

    public Flashcard createFlashcard(Flashcard flashcard);

    public List<Flashcard> getSubjectFlashcard(String studentId, int limit);


    public List<Flashcard> getAllRecords();
}
