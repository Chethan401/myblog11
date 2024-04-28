package com.myblog.myblog11.service;

import com.myblog.myblog11.payload.CommentDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentServices {
    CommentDto createComment(CommentDto commentDto, long postId);
}
