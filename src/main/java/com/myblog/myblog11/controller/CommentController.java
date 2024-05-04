package com.myblog.myblog11.controller;

import com.myblog.myblog11.payload.CommentDto;
import com.myblog.myblog11.service.CommentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentServices commentServices;
    public CommentController(CommentServices commentServices) {
        this.commentServices = commentServices;
    }
    //http://localhost:8080/api/comments?postId=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postId
    ) {
        CommentDto dto = commentServices.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/comments/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id) {
        commentServices.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted!!", HttpStatus.OK);
    }
    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable long id, @RequestBody CommentDto commentDto, @PathVariable long postId) {
        CommentDto dto = commentServices.updateComment(id, commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}