package  com.github.sebastiangarfias.taskmanager.model;

import jakarta.persistence.*;

import java.time.*;

/**
 * This is the main entity for a task in the application.
 * It currently stores all basic task information. The design is kept simple
 * for now because it might change later. In the future, I may use an
 * Interface, a Factory pattern, or inheritance to handle different
 * types of tasks
 *
 * @author Sebastian Kramer Garfias
 */
@Entity
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    protected Task(){};

    public Task(String title,
                Category category,
                String description){
        this.title = title;
        this.category = category;
        this.description = description;
        this.status = Status.IN_WORK;
        this.createdAt = LocalDateTime.now();
    }

    public void changeStatus(Status newStatus){
        if(this.status==Status.DONE) throw new IllegalArgumentException("if status is done it can't be changed" );
        this.status = newStatus;
    }
}