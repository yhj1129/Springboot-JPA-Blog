package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//@AuthenticationPrincipal PrincipalDetail principal
@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping({"", "/"})
    public String index(Model model){ // 데이터를 들고 view에 가야함
        model.addAttribute("boards", boardService.글목록());
        return "index"; //viewResolver 작동하는데 모델 들고 감
    }

    //USER 권한이 필요함
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}
