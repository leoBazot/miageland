package com.appent.miageland.utilities;

import com.appent.miageland.export.TypeEmploye;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Autorisations {
    public static final List<TypeEmploye> VALIDER_BILLET = List.of(TypeEmploye.EMPLOYE);

    public static final List<TypeEmploye> GERER_ATTRACTION = List.of(TypeEmploye.GERANT, TypeEmploye.ADMINISTRATEUR);

    public static final List<TypeEmploye> GERER_PERSONNEL = List.of(TypeEmploye.GERANT);

    public static final List<TypeEmploye> SUPERVISER_PARC = List.of(TypeEmploye.GERANT);
}
