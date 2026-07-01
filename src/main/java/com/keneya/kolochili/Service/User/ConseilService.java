package com.keneya.kolochili.Service.User;

import com.keneya.kolochili.MODEL.Conseil;
import com.keneya.kolochili.Repository.ConseilRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConseilService {

    private final ConseilRepository conseilRepository;

    // Injection par constructeur (recommandé par SOLID)
    public ConseilService(ConseilRepository conseilRepository) {
        this.conseilRepository = conseilRepository;
    }

    // 1. Fonctionnalité : Lister tous les conseils
    public List<Conseil> obtenirTousLesConseils() {
        return conseilRepository.findAll();
    }

    // 2. Fonctionnalité : Trouver un conseil par son ID
    public Optional<Conseil> obtenirConseilParId(int id) {
        return conseilRepository.findById(id);
    }

    // 3. Fonctionnalité : Créer un conseil
    public Conseil creerConseil(Conseil conseil) {
        return conseilRepository.save(conseil);
    }

    // 4. Fonctionnalité : Modifier un conseil
    public Conseil modifierConseil(int id, Conseil conseilModifie) {
        return conseilRepository.findById(id).map(conseil -> {
            conseil.setTitre(conseilModifie.getTitre());
            conseil.setContenu(conseilModifie.getContenu());
            conseil.setTag(conseilModifie.getTag());
            conseil.setCategorieConseil(conseilModifie.getCategorieConseil());
            conseil.setAgent(conseilModifie.getAgent());
            return conseilRepository.save(conseil);
        }).orElseThrow(() -> new RuntimeException("Conseil non trouvé avec l'id : " + id));
    }

    // 5. Fonctionnalité : Supprimer un conseil
    public void supprimerConseil(int id) {
        conseilRepository.deleteById(id);
    }
}

