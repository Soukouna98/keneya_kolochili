package com.keneya.kolochili.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.DTO.Request.CitoyenActivitePlanDTORequest;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.CitoyenActivitePlanDTOResponse;
import com.keneya.kolochili.IService.ICitoyenActivitePlanService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plans")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CitoyenActivitePlanController {

    private final ICitoyenActivitePlanService service;

    @PostMapping
    public ResponseEntity<APIResponse<CitoyenActivitePlanDTOResponse>> create(
            @Valid @RequestBody CitoyenActivitePlanDTORequest dto) {

        CitoyenActivitePlanDTOResponse response = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse<>(
                        true,
                        "Plan créé avec succès",
                        response
                ));
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<CitoyenActivitePlanDTOResponse>>> getAll() {

        List<CitoyenActivitePlanDTOResponse> response = service.getAll();

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Liste des plans",
                        response
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<CitoyenActivitePlanDTOResponse>> getById(
            @PathVariable Long id) {

        CitoyenActivitePlanDTOResponse response = service.getById(id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Plan trouvé",
                        response
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<CitoyenActivitePlanDTOResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody CitoyenActivitePlanDTORequest dto) {

        CitoyenActivitePlanDTOResponse response = service.update(id, dto);

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Plan modifié avec succès",
                        response
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Object>> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Plan supprimé avec succès",
                        null
                )
        );
    }

}