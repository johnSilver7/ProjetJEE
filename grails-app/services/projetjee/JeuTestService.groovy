package projetjee



import grails.transaction.Transactional

@Transactional
class JeuTestService {

    Musee archivesToulouse;
    Musee cmav;
    Musee jacobins;
    //DemandeVisite uneDemandeVisite;
    Gestionnaire gestionnaireMusee;
    Adresse archivesPost;
    Adresse cmavPost;
    Adresse jacobinsPost;

    MuseeService museeService;



    def createJeuTestforMusee() {
        if (Musee.count()==0) {

            gestionnaireMusee = new Gestionnaire(
                    nom: "Gestionnaire des musees de Toulouse"
            ).save(flush: true)

            archivesPost = new Adresse(
                    numeroA: "2",
                    rue: "RUE DES ARCHIVES",
                    ville: "Toulouse",
                    codePostal: "31500"
            ).save(flush: true)

            archivesToulouse = new Musee(
                    nom: "ARCHIVES MUNICIPALES TOULOUSE",
                    horairesOuverture: "Ouvert du lundi au vendredi de 9h à 17h.",
                    telephone: "05 61 61 63 33",
                    accesMetro: "Roseraie (A)",
                    site: "www.urban-hist.toulouse.fr",
                    gestionnaire: gestionnaireMusee,
                    adresse: archivesPost
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
                    adresse: cmavPost
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
                    adresse: jacobinsPost

            ).save(flush: true)

            jacobins = museeService.insertOrUpdateMuseeForGestionnaire(jacobins,gestionnaireMusee)
        }
    }
}
