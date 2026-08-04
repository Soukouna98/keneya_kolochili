package com.keneya.kolochili.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.DTO.Request.CategorieConseilDTORequest;
import com.keneya.kolochili.DTO.Response.CategorieConseilDTOResponse;
import com.keneya.kolochili.Enumeration.TypeRole;
import com.keneya.kolochili.Exception.ForbiddenException;
import com.keneya.kolochili.IService.ICategorieConseilService;
import com.keneya.kolochili.MODEL.Admin;
import com.keneya.kolochili.MODEL.CategorieConseil;
import com.keneya.kolochili.MODEL.Utilisateur;
import com.keneya.kolochili.Repository.AdminRepository;
import com.keneya.kolochili.Repository.CategorieConseilRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieConseilService implements ICategorieConseilService {

        private final CategorieConseilRepository repository;

        private final AdminRepository adminRepository;

        private final java.util.function.Function<CategorieConseil, CategorieConseilDTOResponse> responseMapper;

        @Override
        public void creer(CategorieConseilDTORequest request) {
                Utilisateur user = CurrentUserContext.get();
                Admin admin = adminRepository.findById(user.getId())
                                .orElseThrow(() -> new EntityNotFoundException("Administrateur introuvable"));
                CategorieConseil categorie = new CategorieConseil();
                if (repository.findByNom(request.nom()).isPresent()) {
                        throw new IllegalArgumentException("Nom existe deja dans la base de donnee");
                }
                categorie.setNom(request.nom());
                categorie.setDescription(request.description());
                categorie.setAdmin(admin);

                repository.save(categorie);
        }

        @Override
        public void modifier(CategorieConseilDTORequest request, Long id) {
                Utilisateur user = CurrentUserContext.get();
                Admin admin = adminRepository.findById(user.getId())
                                .orElseThrow(() -> new EntityNotFoundException("Administrateur introuvable"));
                CategorieConseil categorie = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'ID : " + id));
                if (!request.nom().equals(categorie.getNom())) {
                        if (repository.findByNom(request.nom()).isPresent()) {
                                throw new IllegalArgumentException("Nom existe deja dans la base de donnee");
                        }
                }
                categorie.setNom(request.nom());
                categorie.setDescription(request.description());
                categorie.setAdmin(admin);

                repository.save(categorie);
        }

        @Override
        public void supprimer(Long id) {
         Utilisateur user = CurrentUserContext.get();
         if(!TypeRole.ADMIN.equals(user.getRole().getName())){
                throw new ForbiddenException("Vous n'avez pas les droits necessaires(ADMIN)");
         }
                CategorieConseil categorie = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Impossible de supprimer : Catégorie introuvable avec l'ID : " + id));

                categorie.setArchive(true);
                repository.save(categorie);
        }

        @Override
        public void desarchiver(Long id) {
         Utilisateur user = CurrentUserContext.get();
         if(!TypeRole.ADMIN.equals(user.getRole().getName())){
                throw new ForbiddenException("Vous n'avez pas les droits necessaires(ADMIN)");
         }
                CategorieConseil categorie = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Impossible de supprimer : Catégorie introuvable avec l'ID : " + id));

                categorie.setArchive(false);
                repository.save(categorie);
        }

        @Override
        public CategorieConseilDTOResponse findById(Long id) {
                return repository.findById(id)
                                .map(responseMapper)
                                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'ID : " + id));
        }

        @Override
public List<CategorieConseilDTOResponse> getAll() {

    System.out.println("Début getAll()");

    List<CategorieConseil> categories = repository.findByArchiveFalse();

    System.out.println("Nombre de catégories : " + categories.size());

    return categories.stream()
            .map(responseMapper)
            .collect(Collectors.toList());
}
}