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

import com.keneya.kolochili.DTO.Request.CategorieActiviteDTORequest;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.CategorieActiviteDTOResponse;
import com.keneya.kolochili.IService.ICategorieActiviteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "categorie-activites", produces = "application/json")
@RequiredArgsConstructor
public class CategorieController {

    private final ICategorieActiviteService categorieService;

    @GetMapping
    public ResponseEntity<APIResponse<List<CategorieActiviteDTOResponse>>> getAllCategories() {
        List<CategorieActiviteDTOResponse> categories = categorieService.getAllCategories();
        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Catégories récupérées avec succès",
                        categories)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<CategorieActiviteDTOResponse>> getCategoryById(@PathVariable Long id) {
        CategorieActiviteDTOResponse category = categorieService.getCategoryById(id);
        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Catégorie récupérée avec succès",
                        category)
        );
    }

    @GetMapping("/active")
    public ResponseEntity<APIResponse<List<CategorieActiviteDTOResponse>>> getActiveCategories() {
        List<CategorieActiviteDTOResponse> categories = categorieService.getActiveCategories();
        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Catégories actives récupérées avec succès",
                        categories)
        );
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<APIResponse<CategorieActiviteDTOResponse>> createCategory(
            @Valid @RequestBody CategorieActiviteDTORequest request) {
        CategorieActiviteDTOResponse category = categorieService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new APIResponse<>(
                        true,
                        "Catégorie créée avec succès",
                        category)
        );
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<APIResponse<CategorieActiviteDTOResponse>> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategorieActiviteDTORequest request) {
        CategorieActiviteDTOResponse category = categorieService.updateCategory(id, request);
        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Catégorie mise à jour avec succès",
                        category)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Object>> deleteCategory(@PathVariable Long id) {
        categorieService.deleteCategory(id);
        return ResponseEntity.ok(
                new APIResponse<>(
                        true,
                        "Catégorie supprimée avec succès",
                        null)
        );
    }
}
