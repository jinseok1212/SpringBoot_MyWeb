package com.coding404.myweb.controller;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    @Qualifier("topicService")
    private TopicService topicService;

    @GetMapping("/topicListMe")
    public String topicListMe() {
        return ("/topic/topicListMe");
    }

    @GetMapping("/topicDetail")
    public String topicDetail() {

        return ("/topic/topicDetail");
    }

    @GetMapping("/topicListAll")
    public String topicListAll() {
        return ("/topic/topicListAll");
    }
    @GetMapping("/topicModify")
    public String topicModify() {
        return ("/topic/topicModify");
    }
    @GetMapping("/topicReg")
    public String topicReg() {
        return ("/topic/topicReg");
    }

    //글등록
    @PostMapping("/registForm")
    public String registForm(TopicVO vo, RedirectAttributes ra) {
        int result = topicService.topicInsert(vo);
        if(result == 1) {
            ra.addFlashAttribute("msg", "정상 등록되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "등록에 실패했습니다.");
        }
        return "redirect:/topic/topicListMe";
    }
}
