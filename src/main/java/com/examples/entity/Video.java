package com.examples.entity;

import com.examples.service.FileService;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table (name = "videos")
public class Video {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @NotBlank
    @Size (min = 1, max = 100)
    private String name;
    @NotBlank
    private String category;
    @Size(max = 300)
    @NotBlank
    private String description;
    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;
    @NotBlank
    private String videofilename;
    private String imagefilename;
    private String fullvideofilename = String.format("%s_%s", LocalDateTime.now().getNano(), videofilename);
    private String fullimagefilename = String.format("%s_%s", LocalDateTime.now().getNano(), imagefilename);

    public void addComment (Comment comment) {
        if(comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

}
