package projetjee

import grails.transaction.Transactional

@Transactional
class JeuTestService {
    Musee archivesToulouse;
    Musee cmav;
    Musee jacobins;
    Musee almu;
    Musee lymu;
    Musee parmu;
    //DemandeVisite uneDemandeVisite;
    Gestionnaire gestionnaireMusee;
    Adresse archivesPost;
    Adresse cmavPost;
    Adresse jacobinsPost;
    Adresse adreFrist;
    Adresse adrely;
    Adresse adrePa;

    MuseeService museeService;

    def createJeuTestforMusee() {
        if (Musee.count()==0) {

            gestionnaireMusee = new Gestionnaire(
                    nom: "Gestionnaire favoris"
            ).save(flush: true)

            archivesPost = new Adresse(
                    numeroA: "2",
                    rue: "RUE DES ARCHIVES",
                    ville: "Toulouse",
                    codePostal: "31500"
            ).save(flush: true,failOnError: true)

            archivesToulouse = new Musee(
                    nom: "ARCHIVES MUNICIPALES TOULOUSE",
                    horairesOuverture: "Ouvert du lundi au vendredi de 9h à 17h.",
                    telephone: "05 61 61 63 33",
                    accesMetro: "Roseraie (A)",
                    site: "www.urban-hist.toulouse.fr",
                    gestionnaire: gestionnaireMusee,
                    adresse: archivesPost,
                    favori: "oui"
            ).save(flush: true)

            archivesToulouse = museeService.insertOrUpdateMuseeForGestionnaire(archivesToulouse,gestionnaireMusee)

            cmavPost = new Adresse(
                    numeroA: "5",
                    rue: "RUE SAINT PANTALEON",
                    ville: "Toulouse",
                    codePostal: "31000"
            ).save(flush: true)

            cmav = new Musee(
                    nom: "CMAV - CENTRE MERIDIONAL DE L'ARCHITECTURE DE LA VILLE",
                    horairesOuverture: "Ouvert du mardi au samedi de 13h à 19hfermé les dimanches",
                    telephone: "05 61 23 30 49",
                    accesMetro: "Capitole (A)",
                    site: "www.cmaville.org",
                    gestionnaire: gestionnaireMusee,
                    adresse: cmavPost,
                    favori: "non"
            ).save(flush: true)

            cmav = museeService.insertOrUpdateMuseeForGestionnaire(cmav,gestionnaireMusee)

            jacobinsPost = new Adresse(
                    numeroA: "10",
                    rue: "RUE PARGAMINIERES",
                    ville: "Toulouse",
                    codePostal: "31000"
            ).save(flush: true)

            jacobins = new Musee(
                    nom: "ENSEMBLE CONVENTUEL DES JACOBINS",
                    horairesOuverture: "Ouvert tous les jours de 9h à 19h.",
                    telephone: "05 61 22 21 92",
                    accesMetro: "Esquirol (A)",
                    site: "www.jacobins.mairie-toulouse.fr",
                    gestionnaire: gestionnaireMusee,
                    adresse: jacobinsPost,
                    favori: "oui"

            ).save(flush: true)

          jacobins = museeService.insertOrUpdateMuseeForGestionnaire(jacobins,gestionnaireMusee)


            adreFrist = new Adresse(
                    numeroA: "18",
                    rue: "RUE PARC",
                    ville: "Albi",
                    codePostal: "81000"
            ).save(flush: true)

            almu = new Musee(
                    nom: "ENSEMBLE CONVENTUEL",
                    horairesOuverture: "Ouvert tous les jours de 9h à 19h.",
                    telephone: "05 61 22 21 98",
                    accesMetro: "Esquirol (A)",
                    site: "www.jacobins.mairie-toulouse.fr",
                    gestionnaire: gestionnaireMusee,
                    adresse: adreFrist,
                    favori: "non"

            ).save(flush: true)

            almu = museeService.insertOrUpdateMuseeForGestionnaire(almu,gestionnaireMusee)

            adrely = new Adresse(
                    numeroA: "18",
                    rue: "RUE DE ROSSAIRE",
                    ville: "Lyon",
                    codePostal: "81000"
            ).save(flush: true)

            lymu = new Musee(
                    nom: "ENSEMBLE CONVENTUEL DE LYON",
                    horairesOuverture: "Ouvert tous les jours de 9h à 19h.",
                    telephone: "05 61 22 21 98",
                    accesMetro: "Esquirol (A)",
                    site: "www.jacobins.mairie-toulouse.fr",
                    gestionnaire: gestionnaireMusee,
                    adresse: adrely,
                    favori: "non"

            ).save(flush: true)

            lymu = museeService.insertOrUpdateMuseeForGestionnaire(lymu,gestionnaireMusee)

            adrePa = new Adresse(
                    numeroA: "1100",
                    rue: "RUE DE ROSSAIRE",
                    ville: "PARIS",
                    codePostal: "81000"
            ).save(flush: true)

            parmu = new Musee(
                    nom: "ENSEMBLE CONVENTUEL DE PARIS",
                    horairesOuverture: "Ouvert tous les jours de 9h à 19h.",
                    telephone: "05 61 22 21 20",
                    accesMetro: "Esquirol (A)",
                    site: "www.jacobins.mairie-toulouse.fr",
                    gestionnaire: gestionnaireMusee,
                    adresse: adrePa,
                    favori: "non"

            ).save(flush: true)

            parmu = museeService.insertOrUpdateMuseeForGestionnaire(parmu,gestionnaireMusee)
        }
    }


}
