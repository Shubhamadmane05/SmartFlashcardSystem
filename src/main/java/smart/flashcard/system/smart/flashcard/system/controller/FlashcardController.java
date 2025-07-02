package smart.flashcard.system.smart.flashcard.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smart.flashcard.system.smart.flashcard.system.model.Flashcard;
import smart.flashcard.system.smart.flashcard.system.service.FlashcardService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flashcard")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @PostMapping("/add")
    public Map<String, String> addFlashcard(@RequestBody Flashcard flashcard) {
        Flashcard saved = flashcardService.createFlashcard(flashcard);
        return Map.of(
                "message", "Flashcard added successfully",
                "subject", saved.getSubject()
        );
    }

   @GetMapping("/get-subject")
    public List<Flashcard> getSubject(@RequestParam("studentId") String studentId,
                                      @RequestParam int limit){
        return flashcardService.getSubjectFlashcard(studentId, limit);
    }

    @GetMapping("/all")
    public List<Flashcard> getAll(){
        return flashcardService.getAllRecords();
    }
}
