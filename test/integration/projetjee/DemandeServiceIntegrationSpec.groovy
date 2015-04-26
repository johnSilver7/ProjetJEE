package projetjee


import spock.lang.*

/**
 *
 */
class DemandeServiceIntegrationSpec extends Specification {

    DemandeService demandeService

    void "test de traitement de demande de visite  d'un musee"() {

        given: "un musee"
        Adresse adresse1 = new Adresse(numeroA: "2", rue: "rue", ville: "Albi", codePostal: "81000").save(flush: true)


        and: "un gestionnaire"
        Gestionnaire gestion = new Gestionnaire(nom: "gestionnaire favoris").save(flush: true)

        when: "on tente de répercuter en base la création ou la modification de musee"


        Musee unMusee = new Musee(nom: "un nom", horairesOuverture: "10h", telephone: "02 47 85 64 85", accesMetro: "Jean Jaures", site: "www.albi.fr", gestionnaire: gestion, adresse: adresse1, favori: "oui").save(flush: true)

        adresse1.save(flush: true)

        gestion.save(flush: true)


        then: "On tente de faire un traitement de demande"
        String demandeservice = demandeService.traiterDemande(unMusee.nom, "2015.10.11", "2015.10.12", "3")

        and: "On tente de vérifier que le resultat n'est pas nul"
        demandeservice != null

        and: "On verifie que la date est valide"
        demandeservice != 'err_date'

        and: "On verifie que le nombre de personne est valide"
        demandeservice != 'err_pers'

    }

    void "test de l'invalidite d'une demande"() {

        given: "un musee"
        Adresse adresse1 = new Adresse(numeroA: "2", rue: "rue", ville: "Albi", codePostal: "81000").save(flush: true)


        and: "un gestionnaire"
        Gestionnaire gestion = new Gestionnaire(nom: "gestionnaire favoris").save(flush: true)

        when: "on tente de répercuter en base la création ou la modification de musee"


        Musee unMusee = new Musee(nom: "un nom", horairesOuverture: "10h", telephone: "02 47 85 64 85", accesMetro: "Jean Jaures", site: "www.albi.fr", gestionnaire: gestion, adresse: adresse1, favori: "oui").save(flush: true)

        adresse1.save(flush: true)

        gestion.save(flush: true)


        then: "On tente de faire un traitement de demande"
        String demandeservice = demandeService.traiterDemande(unMusee.nom, "2015.10.11", "2015.10.10", "3")

        and: "On tente de vérifier que le resultat n'est pas nul"
        demandeservice != null

        and: "On verifie que la date est valide"
        demandeservice == 'err_date'

        and: "On verifie que le nombre de personne est valide"
        demandeservice != 'err_pers'

    }

    void "test de l'invalidite d'une demande erreur de date"() {

        given: "un musee"
        Adresse adresse1 = new Adresse(numeroA: "2", rue: "rue", ville: "Albi", codePostal: "81000").save(flush: true)


        and: "un gestionnaire"
        Gestionnaire gestion = new Gestionnaire(nom: "gestionnaire favoris").save(flush: true)

        when: "on tente de répercuter en base la création ou la modification de musee"


        Musee unMusee = new Musee(nom: "un nom", horairesOuverture: "10h", telephone: "02 47 85 64 85", accesMetro: "Jean Jaures", site: "www.albi.fr", gestionnaire: gestion, adresse: adresse1, favori: "oui").save(flush: true)

        adresse1.save(flush: true)

        gestion.save(flush: true)


        then: "On tente de faire un traitement de demande"
        String demandeservice = demandeService.traiterDemande(unMusee.nom, "2015.10.11.11", "2015.10.11.11", "3")

        and: "On tente de vérifier que le resultat n'est pas nul"
        demandeservice != null

        and: "On verifie que la date est valide"
        demandeservice == 'err_date'

        and: "On verifie que le nombre de personne est valide"
        demandeservice != 'err_pers'

    }

    void "test de l'invalidite d'une demande erreur date"() {

        given: "un musee"
        Adresse adresse1 = new Adresse(numeroA: "2", rue: "rue", ville: "Albi", codePostal: "81000").save(flush: true)


        and: "un gestionnaire"
        Gestionnaire gestion = new Gestionnaire(nom: "gestionnaire favoris").save(flush: true)

        when: "on tente de répercuter en base la création ou la modification de musee"


        Musee unMusee = new Musee(nom: "un nom", horairesOuverture: "10h", telephone: "02 47 85 64 85", accesMetro: "Jean Jaures", site: "www.albi.fr", gestionnaire: gestion, adresse: adresse1, favori: "oui").save(flush: true)

        adresse1.save(flush: true)

        gestion.save(flush: true)


        then: "On tente de faire un traitement de demande"
        String demandeservice = demandeService.traiterDemande(unMusee.nom, "dwqdq", "2015.10.11", "3")

        and: "On tente de vérifier que le resultat n'est pas nul"
        demandeservice != null

        and: "On verifie que la date est valide"
        demandeservice == 'err_date'

        and: "On verifie que le nombre de personne est valide"
        demandeservice != 'err_pers'

    }

    void "test de l'invalidite d'une demande erreur pers"() {

        given: "un musee"
        Adresse adresse1 = new Adresse(numeroA: "2", rue: "rue", ville: "Albi", codePostal: "81000").save(flush: true)


        and: "un gestionnaire"
        Gestionnaire gestion = new Gestionnaire(nom: "gestionnaire favoris").save(flush: true)

        when: "on tente de répercuter en base la création ou la modification de musee"


        Musee unMusee = new Musee(nom: "un nom", horairesOuverture: "10h", telephone: "02 47 85 64 85", accesMetro: "Jean Jaures", site: "www.albi.fr", gestionnaire: gestion, adresse: adresse1, favori: "oui").save(flush: true)

        adresse1.save(flush: true)

        gestion.save(flush: true)


        then: "On tente de faire un traitement de demande"
        String demandeservice = demandeService.traiterDemande(unMusee.nom, "2015.10.11", "2015.10.12", "a")

        and: "On tente de vérifier que le resultat n'est pas nul"
        demandeservice != null

        and: "On verifie que la date est valide"
        demandeservice != 'err_date'

        and: "On verifie que le nombre de personne est valide"
        demandeservice == 'err_pers'

    }
}
