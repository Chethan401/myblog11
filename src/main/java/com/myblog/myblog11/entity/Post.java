package com.myblog.myblog11.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String content;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
