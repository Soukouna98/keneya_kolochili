package com.keneya.kolochili.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.DTO.Request.CitoyenActivitePlanDTORequest;
import com.keneya.kolochili.DTO.Response.CitoyenActivitePlanDTOResponse;
import com.keneya.kolochili.IService.ICitoyenActivitePlanService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class CitoyenActivitePlanController {

    private final ICitoyenActivitePlanService service;

    @PostMapping
    public ResponseEntity<CitoyenActivitePlanDTOResponse>
    create(
            @Valid
            @RequestBody
            CitoyenActivitePlanDTORequest dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitoyenActivitePlanDTOResponse>
    getById(@PathVariable Long id) {

        return ResponseEntity.ok(
                service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CitoyenActivitePlanDTOResponse>>
    getAll() {

        return ResponseEntity.ok(
                service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }
    @PutMapping("/{id}")
        public ResponseEntity<CitoyenActivitePlanDTOResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CitoyenActivitePlanDTORequest dto) {

        return ResponseEntity.ok(
                service.update(id, dto));
    }
} 
