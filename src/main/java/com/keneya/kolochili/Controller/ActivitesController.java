
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.keneya.kolochili.DTO.Request.User.ActivitesDTORequest;
import com.keneya.kolochili.DTO.Response.APIResponse;
import com.keneya.kolochili.DTO.Response.User.ActivitesDTOResponse;
import com.keneya.kolochili.Service.ActivitesService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/activites", produces = "application/json")
@RequiredArgsConstructor
public class ActivitesController {

    
    @Autowired private final ActivitesService activitesService;

    // CREATE
    @PostMapping(consumes = "application/json")
    public ResponseEntity<APIResponse<Object>> creer(
            @Valid @RequestBody ActivitesDTORequest dto) {

        activitesService.creer(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse<>(
                        true,
                        "Activité créée avec succès",
                        null
                ));
    }

    // UPDATE
    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<APIResponse<Object>> modifier(
            @PathVariable Long id,
            @Valid @RequestBody ActivitesDTORequest dto) {

        activitesService.modifier(dto, id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse<>(
                        true,
                        "Activité modifiée avec succès",
                        null
                ));
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ActivitesDTOResponse>> lire(
            @PathVariable Long id) {

        ActivitesDTOResponse response = activitesService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse<>(
                        true,
                        "Activité trouvée avec succès",
                        response
                ));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<APIResponse<List<ActivitesDTOResponse>>> liste() {

        List<ActivitesDTOResponse> responses = activitesService.getAll();

        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse<>(
                        true,
                        "Liste des activités",
                        responses
                ));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Object>> supprimer(
            @PathVariable Long id) {

        activitesService.supprimer(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new APIResponse<>(
                        true,
                        "Activité supprimée avec succès",
                        null
                ));
    }
}