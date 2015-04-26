package projetjee


import spock.lang.*

/**
 *
 */
class JeuTestServiceIntegrationSpec extends Specification {

   /* JeuTestService jeuTestService


    void "test creation jeu de tests pour musees"() {

        given:"la liste de musee est vide au debut"
        Musee.count() == 0

        when: "on crée le jeu de test pour les musees"
        jeuTestService.createJeuTestforMusee()

        then: "7 nouveaux musees ont été crées en base"
        Musee.count() == 6

        and:"on tente de supprimer un gestionnaire"

        Adresse adresse1 =  new Adresse(numeroA: "2", rue: "rue",ville: "Albi",codePostal: "81000")

        and:" on tente de creer un gestionnaire"

        Gestionnaire gestion= new Gestionnaire(nom: "Doo")

        and:"on tente de creer un musee"
        Musee unMusee = new Musee(nom:"un nom", horairesOuverture: "10h",telephone: "02 47 85 64 85",accesMetro: "Jean Jaures",site: "www.albi.fr",gestionnaire: gestion, adresse: adresse1,favori: "oui")

        adresse1.save(flush: true)
        gestion.save(flush: true)

        and:"on tente de supprimer"
        jeuTestService.supprimerDuGestionnnaire(unMusee)

    }*/
}
