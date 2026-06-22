package cr;

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

import com.keneya.kolochili.DTO.Request.User.CitoyenDTORequest;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.User.CitoyenDTOResponse;
import com.keneya.kolochili.Service.User.CitoyenService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/citoyens", produces = "application/json")
@RequiredArgsConstructor
public class CitoyenControlller {

        private final CitoyenService citoyenService;

        @PostMapping(consumes = "application/json")
        public ResponseEntity<APIResponse<CitoyenDTORequest>> creer(@Valid @RequestBody CitoyenDTORequest citoyenDTO) {
                citoyenService.creer(citoyenDTO);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(
                                new APIResponse<>(
                                        true,
                                        "Citoyen inserer avec success",
                                        null
                                )
                        );
        }

        @PutMapping(path = "/{id}", consumes = "application/json")
        public ResponseEntity<APIResponse<CitoyenDTOResponse>> modifier(@Valid @RequestBody CitoyenDTORequest citoyenDTO, @PathVariable Long id) {
                citoyenService.modifier(citoyenDTO, id);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(
                                new APIResponse<>(
                                        true,
                                        "Citoyen modifier avec success",
                                        null
                                )
                        );
        }

        @GetMapping("/{id}")
        public ResponseEntity<APIResponse<CitoyenDTOResponse>> lire(@PathVariable Long id) {
                CitoyenDTOResponse citoyenDTOResponse = citoyenService.getById(id);

                return ResponseEntity.status(HttpStatus.OK)
                        .body(new APIResponse<>(
                                true,
                                "Citoyen trouve avec success",
                                citoyenDTOResponse
                        )
                        );
        }

        @GetMapping
        public ResponseEntity<APIResponse<List<CitoyenDTOResponse>>> liste() {
                List<CitoyenDTOResponse> citoyenDTOResponses = citoyenService.getAll();

                return ResponseEntity.status(HttpStatus.OK)
                        .body(new APIResponse<>(
                                true,
                                "Voici la liste des citoyens",
                                citoyenDTOResponses
                        )
                        );
        }

        @PatchMapping("/{id}/archiver")
        public ResponseEntity<APIResponse<Object>> archiver(@PathVariable Long id) {
                citoyenService.archiver(id);

                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(new APIResponse<>(
                                true,
                                "Citoyen archiver avec success",
                                null)
                        );
        }

        @PatchMapping("/{id}/de-archiver")
        public ResponseEntity<APIResponse<Object>> desArchiver(@PathVariable Long id) {
                citoyenService.deArchiver(id);

                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(new APIResponse<>(
                                true,
                                "Citoyen desarchiver avec success",
                                null)
                        );
        }
}
