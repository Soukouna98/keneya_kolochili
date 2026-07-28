package DTO.Request.User;

import lombok.Data;

@Data
public class AgentDTORequest {
    // Champs hérités ou liés à l'utilisateur
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String phone;
    
    // Champ spécifique à l'agent
    private String specialite; 
}