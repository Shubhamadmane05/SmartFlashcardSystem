package smart.flashcard.system.smart.flashcard.system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.flashcard.system.smart.flashcard.system.model.Flashcard;
import smart.flashcard.system.smart.flashcard.system.repository.FlashcardRepository;


import java.util.*;

@Service
public class FlashcardServiceImpl implements FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;
    @Override
    public Flashcard createFlashcard(Flashcard flashcard) {
       String inferredSubjet=inferSubject(flashcard.getQuestion());
       flashcard.setSubject(inferredSubjet);
       return  flashcardRepository.save(flashcard);
    }

    @Override
    public List<Flashcard> getSubjectFlashcard(String studentId, int limit) {
        List<Flashcard> all = flashcardRepository.findByStudentId(studentId);
        Map<String, List<Flashcard>> grouped = new HashMap<>();

        for (Flashcard flashcard : all) {
            grouped.computeIfAbsent(flashcard.getSubject(), k -> new ArrayList<>()).add(flashcard);
        }

        List<Flashcard> result = new ArrayList<>();
        Random random = new Random();

        while (result.size() < limit && !grouped.isEmpty()) {
            List<String> subjects = new ArrayList<>(grouped.keySet());

            for (String subject : subjects) {
                List<Flashcard> cards = grouped.get(subject);
                if (cards != null && !cards.isEmpty()) {
                    result.add(cards.remove(0)); // pick one card from each subject
                }

                //   remove subject group if empty
                if (cards == null || cards.isEmpty()) {
                    grouped.remove(subject);
                }

                // Exit early if limit is reached
                if (result.size() >= limit) break;
            }
        }

        Collections.shuffle(result); // mix them
        return result;
    }

    @Override
    public List<Flashcard> getAllRecords() {
        return flashcardRepository.findAll();
    }


    private String inferSubject(String question) {
        question = question.toLowerCase();
        if (question.contains("gravity") || question.contains("gravity") || question.contains("acceleration") || question.contains("law") || question.contains("newton"))
            return "Physics";
        if (question.contains("photosynthesis") || question.contains("cell") || question.contains("plant") || question.contains("organism"))
            return "Biology";
        if (question.contains("war") || question.contains("independence") || question.contains("revolution"))
            return "History";
        if (question.contains("equation") || question.contains("algebra") || question.contains("geometry") || question.contains("number"))
            return "Mathematics";

        return "General";
    }}

