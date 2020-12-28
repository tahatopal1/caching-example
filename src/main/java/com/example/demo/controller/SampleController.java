package com.example.demo.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @GetMapping(value = "/caching", produces = MediaType.APPLICATION_JSON_VALUE)
    @Cacheable("sample") // Caches the result unless the parameter changes
    public ResponseEntity<String> getBookFromGoogle(@RequestParam String q) throws InterruptedException {
        Thread.sleep(5000); // Indicates if the result is cached or not
        return ResponseEntity.ok(q);
    }
}
