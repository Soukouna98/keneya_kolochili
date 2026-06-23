package com.keneya.kolochili.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.Service.User.AdminService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/admins", produces = "application/json")
@RequiredArgsConstructor
public class AdminControlller {

        private final AdminService adminService;

        @PutMapping(path = "/{id}", consumes = "application/json")
        public ResponseEntity<APIResponse<AdminDTOResponse>> modifier(@Valid @RequestBody AdminDTORequest adminDTO, @PathVariable Long id) {
                adminService.modifier(adminDTO, id);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(
                                new APIResponse<>(
                                        true,
                                        "Admin modifier avec success",
                                        null
                                )
                        );
        }

        @GetMapping("/{id}")
        public ResponseEntity<APIResponse<AdminDTOResponse>> lire(@PathVariable Long id) {
                AdminDTOResponse adminDTOResponse = adminService.getById(id);

                return ResponseEntity.status(HttpStatus.OK)
                        .body(new APIResponse<>(
                                true,
                                "Admin trouve avec success",
                                adminDTOResponse
                        )
                        );
        }
}
