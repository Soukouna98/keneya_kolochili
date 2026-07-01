
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.Config.CurrentUserContext;
import com.keneya.kolochili.DTO.Request.CategorieActiviteDTORequest;
import com.keneya.kolochili.DTO.Response.CategorieActiviteDTOResponse;
import com.keneya.kolochili.Exception.ForbiddenException;
import com.keneya.kolochili.IService.ICategorieActiviteService;
import com.keneya.kolochili.MODEL.Admin;
import com.keneya.kolochili.MODEL.CategorieActivite;
import com.keneya.kolochili.MODEL.Utilisateur;
import com.keneya.kolochili.Repository.AdminRepository;
import com.keneya.kolochili.Repository.CategorieActiviteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieActiviteService implements ICategorieActiviteService {
    
    private final CategorieActiviteRepository categorieRepository;
    private final AdminRepository adminRepository;

    @Override
    public List<CategorieActiviteDTOResponse> getAllCategories() {
        return categorieRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategorieActiviteDTOResponse getCategoryById(Long id) {
        CategorieActivite categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new ForbiddenException("Catégorie non trouvée"));
        return mapToResponse(categorie);
    }

    @Override
    public CategorieActiviteDTOResponse createCategory(CategorieActiviteDTORequest request) {
        Utilisateur user = CurrentUserContext.get();
        Admin admin = adminRepository.findById(user.getId())
                .orElseThrow(() -> new ForbiddenException("Admin non trouvé"));
        CategorieActivite categorie = new CategorieActivite();
        categorie.setLibelle(request.getLibelle());
        categorie.setDescription(request.getDescription());
        categorie.setAdmin(admin);
        categorie.setArchive(false);
        /*Admin admin = adminRepository.findById(request.getIdAdmin())
                .orElseThrow(() -> new ForbiddenException("Admin non trouvé"));
        categorie.setAdmin(admin.getId());*/
        Admin admin1 = adminRepository.findById(request.getIdAdmin())
                .orElseThrow(() -> new ForbiddenException("Admin non trouvé"));
        categorie.setAdmin(admin1);

        CategorieActivite saved = categorieRepository.save(categorie);
        return mapToResponse(saved);
    }

    @Override
    public CategorieActiviteDTOResponse updateCategory(Long id, CategorieActiviteDTORequest request) {
        CategorieActivite categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new ForbiddenException("Catégorie non trouvée"));
        
        categorie.setLibelle(request.getLibelle());
        categorie.setDescription(request.getDescription());
        
        CategorieActivite updated = categorieRepository.save(categorie);
        return mapToResponse(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        CategorieActivite categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new ForbiddenException("Catégorie non trouvée"));
        categorieRepository.delete(categorie);
    }

    @Override
    public List<CategorieActiviteDTOResponse> getActiveCategories() {
        return categorieRepository.findAll()
                .stream()
                .filter(c -> !c.isArchive())
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CategorieActiviteDTOResponse mapToResponse(CategorieActivite categorie) {
        return CategorieActiviteDTOResponse.builder()
                .id(categorie.getId())
                .libelle(categorie.getLibelle())
                .description(categorie.getDescription())
                .archive(categorie.isArchive())
                .build();
    }

    @Override
    public void creer(CategorieActiviteDTORequest entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void modifier(CategorieActiviteDTORequest entity, Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void supprimer(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CategorieActiviteDTOResponse findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CategorieActiviteDTOResponse> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
