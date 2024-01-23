package org.pokemon.controllers;

import lombok.RequiredArgsConstructor;
import org.pokemon.logs.LogsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class LogsController {

    private final LogsService logs;

    @GetMapping("/getLogs")
    public String getLogs(Model model) {
        List<String> log = logs.getAllLogs();
        model.addAttribute("logs", log);
        return "index_logs";
    }

}
