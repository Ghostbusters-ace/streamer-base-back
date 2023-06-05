package fr.aelion.streamer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    private String summary;

    @Column(nullable = false)
    private float duration;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private String url;

    @ManyToOne(targetEntity = TypeMedia.class)
    @JoinColumn(name = "typemedia_id", nullable = false)
    private TypeMedia typeMedia;

    @ManyToOne(targetEntity = Module.class)
    @JoinColumn(name = "module_id", nullable = true)
    private Module module;

    private int order;

    public Media() {
        createdAt = LocalDate.now();


    }
}
