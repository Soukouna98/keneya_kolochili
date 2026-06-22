package aon.pheno.keneya.Mapper.Request.User;

import java.util.function.Function;

import org.springframework.stereotype.Component;


@Component
public class CitoyenDTORequestMapper implements Function<CitoyenDTORequest, Citoyen>{

    @Override
    public Citoyen apply(CitoyenDTORequest t) {
        Citoyen citoyen = new Citoyen();
        citoyen.setNom(t.nom());
        citoyen.setPrenom(t.prenom());
        citoyen.setEmail(t.email());
        citoyen.setPassword(t.password());
        citoyen.setPhone(t.telephone());
        citoyen.setDate_naissance(t.date_naissance());
        return citoyen;
    }
}
