package task_3_rest.trello.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task_3_rest.trello.entities.Card;
import task_3_rest.trello.entities.CardTask;
import task_3_rest.trello.services.CardService;
import task_3_rest.trello.services.TaskService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class MainRestController {
    @Autowired
    private CardService cardService;

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/allCards")
    public ResponseEntity<?> getAllCards(){
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping(value = "/allTasks/{id}")
    public ResponseEntity<?> getTasks(@PathVariable(name="id") Long id){
        List<CardTask> cardTasks = taskService.findAllByCard_Id(id);
        return ResponseEntity.ok(cardTasks);
    }

    @PostMapping(value = "/addcard")
    public ResponseEntity<?> addCard(@RequestBody Card card){
        cardService.addCard(card);
        return ResponseEntity.ok(card);
    }

    @PutMapping(value = "/editCard")
    public ResponseEntity<?> editCard(@RequestBody Card card){
        cardService.updateCard(card);
        return ResponseEntity.ok(card);
    }

    @PutMapping(value = "/editTask")
    public ResponseEntity<?> editTask(@RequestBody CardTask cardTask){
        taskService.updateTask(cardTask);
        return ResponseEntity.ok(cardTask);
    }

    @GetMapping(value = "/getCard/{id}")
    public ResponseEntity<?> getItem(@PathVariable(name = "id") Long id){
        Card card = cardService.getCardById(id);
        return ResponseEntity.ok(card);
    }

    @GetMapping(value = "/getTask/{id}/{cardid}")
    public ResponseEntity<?> getTask(@PathVariable(name = "id") Long id,@PathVariable(name = "cardid") Long cardid){
        Card card = cardService.getCardById(cardid);
        CardTask task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping(value = "/deleteCard")
    public ResponseEntity<?> deleteCard(@RequestBody Card card){
        Card c = cardService.getCardById(card.getId());
        if(c!=null){
            cardService.deleteCard(c);
            return ResponseEntity.ok(c);
        }
        return (ResponseEntity<?>) ResponseEntity.badRequest();
    }

    @DeleteMapping(value = "/deleteTask")
    public ResponseEntity<?> deleteTask(@RequestBody CardTask task){
        CardTask c = taskService.getTaskById(task.getId());
        if(c!=null){
            taskService.deleteTask(c);
            return ResponseEntity.ok(c);
        }
        return (ResponseEntity<?>) ResponseEntity.badRequest();
    }

    @PostMapping(value = "/addTask/{id}")
    public ResponseEntity<?> addTask(@RequestBody CardTask cardTask,@PathVariable(name = "id") Long id){
        //System.out.println(cardTask.getCard().getId());
        Card task = cardService.getCardById(id);
        cardTask.setCard(task);
        taskService.addTask(cardTask);
        return ResponseEntity.ok(cardTask);
    }

    @GetMapping(value = "/searchCard/{name}")
    public ResponseEntity<?> searchCard(@PathVariable String name){
        List<Card> cards = cardService.findAllByNameContaining(name);
        if(cards==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cards);
    }
}
