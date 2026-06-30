package com.keneya.kolochili.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.DTO.PublicationDTO;

import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.IService.IServicePublication;


import jakarta.validation.Valid;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/publication")

public class PublicationController {

        public final IServicePublication service;

        public PublicationController(IServicePublication service) {
                this.service = service;
        }

        @PostMapping

        public ResponseEntity<APIResponse<PublicationDTO>> create(@Valid
                        @RequestBody PublicationDTO dto) {

                service.create(dto);
                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(
                                                new APIResponse<>(
                                                                true,
                                                                "Publication  créée avec success",
                                                                null));

        }

        @GetMapping("/{id}")
        public ResponseEntity<APIResponse<PublicationDTO>> getById(@PathVariable Long id) {
                PublicationDTO publicationDTO = service.getById(id);
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new APIResponse<>(
                                                true,
                                                "La publication a été trouvée avec succès",
                                                publicationDTO

                                ));

        }

        @GetMapping

        public ResponseEntity<APIResponse<List<PublicationDTO>>> List() {
                List<PublicationDTO> publicationDTO = service.getAll();
                return ResponseEntity.status(HttpStatus.OK)
                                .body(
                                                new APIResponse<>(
                                                                true,
                                                                "Voici La listes des publications merci",
                                                                publicationDTO));
        }

        @PutMapping("/{id}")
        public ResponseEntity<APIResponse<PublicationDTO>> update(@PathVariable Long id,
                        @RequestBody PublicationDTO dto) {
                service.update(id, dto);

                return ResponseEntity.status(HttpStatus.OK)
                                .body(
                                                new APIResponse<>(
                                                                true,
                                                                "La publication a été  modifiée avec succès",
                                                                null));
        }

     //Archiver par la methode delete
        @DeleteMapping("/{id}")
        public ResponseEntity<APIResponse<String>> delete(@PathVariable Long id) {

        service.delete(id);

         return ResponseEntity.ok(
            new APIResponse<>(
                    true,
                    "Publication archivée avec succès.",
                    null
            )
    );
}

      

@GetMapping("/archives")
 
    public ResponseEntity<APIResponse<List<PublicationDTO>>> getArchives() {
        List<PublicationDTO> publicationDTO = service.getArchives();
         return ResponseEntity.status(HttpStatus.OK)
                                .body(
                                                new APIResponse<>(
                                                                true,
                                                                "Voici La listes des publications archivées",
                                                                publicationDTO));
        }


        
//         // La partie archive
//         @PatchMapping("/{id}/archiver")
//         public ResponseEntity<APIResponse<Object>> archiver(@PathVariable Long id) {

//                 service.archiver(id);
//                 return ResponseEntity.status(HttpStatus.OK)
//                                 .body(new APIResponse<>(
//                                                 true,
//                                                 "La publication a été bien archivée ",
//                                                 null));
//         }

//     @PatchMapping("/{id}/desarchiver")
//     public ResponseEntity<APIResponse<Object>> desarchiver(@PathVariable Long id) {
//     service.desarchiver(id);
//     return ResponseEntity.status(HttpStatus.OK)
//                         .body(new APIResponse<>(
//                                 true,
//                                 "La publication a été bien desarchivée ",
//                                 null)
//                         );

// }

               



}
