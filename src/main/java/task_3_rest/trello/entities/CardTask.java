package task_3_rest.trello.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "taskText")
    private String taskText;

    @Column(name = "addedDate")
    @JsonFormat(pattern="dd.MM.yyyy, HH:mm")
    private Date addedDate;

    @Column(name = "done")
    private boolean done;

    @ManyToOne(fetch = FetchType.EAGER)
    private Card card;
}
