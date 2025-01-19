package com.khomishchak.belab2.controller;

import com.khomishchak.belab2.model.Record;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    private final List<Record> records = new ArrayList<>();
    private Long idCounter = 1L;

    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        record.setId(idCounter++);
        record.setCreatedAt(LocalDateTime.now());
        records.add(record);
        return record;
    }

    @GetMapping("/{recordId}")
    public Record getRecord(@PathVariable Long recordId) {
        return records.stream().filter(r -> r.getId().equals(recordId)).findFirst().orElse(null);
    }

    @GetMapping
    public List<Record> getRecords(@RequestParam(required = false) Long userId,
                                   @RequestParam(required = false) Long categoryId) {
        return records.stream()
                .filter(r -> (userId == null || r.getUserId().equals(userId)) &&
                        (categoryId == null || r.getCategoryId().equals(categoryId)))
                .toList();
    }

    @DeleteMapping("/{recordId}")
    public void deleteRecord(@PathVariable Long recordId) {
        records.removeIf(r -> r.getId().equals(recordId));
    }
}
