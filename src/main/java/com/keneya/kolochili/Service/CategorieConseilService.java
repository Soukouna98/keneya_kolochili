package com.keneya.kolochili.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.DTO.Request.CategorieConseilDTORequest;
import com.keneya.kolochili.DTO.Response.CategorieConseilDTOResponse;
import com.keneya.kolochili.MODEL.CategorieConseil;
import com.keneya.kolochili.Repository.AdminRepository;
import com.keneya.kolochili.Repository.CategorieConseilRepository;
import com.keneya.kolochili.IService.ICategorieConseilService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieConseilService implements ICategorieConseilService {

    
    private final CategorieConseilRepository repository;


    private final AdminRepository adminRepository;

    
    private final java.util.function.Function<CategorieConseil, CategorieConseilDTOResponse> responseMapper;

    @Override
    public void creer(CategorieConseilDTORequest request) {
        
        Long adminId = Long.valueOf(request.idAdmin());
        var admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Administrateur introuvable"));

        CategorieConseil categorie = new CategorieConseil();
        categorie.setNom(request.nom());
        categorie.setDescription(request.description());
        categorie.setAdmin(admin);

        repository.save(categorie);
    }

    @Override
    public void modifier(CategorieConseilDTORequest request, Long id) {
        CategorieConseil categorie = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'ID : " + id));

        Long adminId = Long.valueOf(request.idAdmin());
        var admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Le nouvel administrateur est introuvable"));

        categorie.setNom(request.nom());
        categorie.setDescription(request.description());
        categorie.setAdmin(admin);

        repository.save(categorie);
    }

    @Override
    public void supprimer(Long id) {
    CategorieConseil categorie = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Impossible de supprimer : Catégorie introuvable avec l'ID : " + id));
    
    categorie.setArchive(true); 
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
    return repository.findByArchiveFalse().stream()
            .map(responseMapper)
            .collect(Collectors.toList());
}
}