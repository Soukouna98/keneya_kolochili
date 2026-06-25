package com.keneya.kolochili.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keneya.kolochili.DTO.Request.User.AgentDTORequest;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.User.AgentDTOResponse;
import com.keneya.kolochili.Service.User.AgentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/agents", produces = "application/json")
@RequiredArgsConstructor
public class AgentControlller {

        private final AgentService agentService;

        @PostMapping(consumes = "application/json")
        public ResponseEntity<APIResponse<AgentDTORequest>> creer(@Valid @RequestBody AgentDTORequest agentDTO) {
                agentService.creer(agentDTO);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(
                                new APIResponse<>(
                                        true,
                                        "Agent insere avec success",
                                        null
                                )
                        );
        }

        @PutMapping(path = "/{id}", consumes = "application/json")
        public ResponseEntity<APIResponse<AgentDTOResponse>> modifier(@Valid @RequestBody AgentDTORequest agentDTO, @PathVariable Long id) {
                agentService.modifier(agentDTO, id);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(
                                new APIResponse<>(
                                        true,
                                        "Agent modifier avec success",
                                        null
                                )
                        );
        }

        @GetMapping("/{id}")
        public ResponseEntity<APIResponse<AgentDTOResponse>> lire(@PathVariable Long id) {
                AgentDTOResponse agentDTOResponse = agentService.getById(id);

                return ResponseEntity.status(HttpStatus.OK)
                        .body(new APIResponse<>(
                                true,
                                "Agent trouve avec success",
                                agentDTOResponse
                        )
                        );
        }

        @GetMapping
        public ResponseEntity<APIResponse<List<AgentDTOResponse>>> liste() {
                List<AgentDTOResponse> agentDTOResponses = agentService.getAll();

                return ResponseEntity.status(HttpStatus.OK)
                        .body(
                                new APIResponse<>(
                                        true,
                                        "Voici la liste des agent",
                                        agentDTOResponses
                                )
                        );
        }

        @PatchMapping("/{id}/archiver")
        public ResponseEntity<APIResponse<Object>> archiver(@PathVariable Long id) {
                agentService.archiver(id);

                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(new APIResponse<>(
                                true,
                                "Agent archiver avec success",
                                null)
                        );
        }

        @PatchMapping("/{id}/de-archiver")
        public ResponseEntity<APIResponse<Object>> desArchiver(@PathVariable Long id) {
                agentService.deArchiver(id);

                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(new APIResponse<>(
                                true,
                                "Agent desarchiver avec success",
                                null)
                        );
        }
        
}
