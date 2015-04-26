package projetjee


import spock.lang.*

/**
 *
 */
class DemandeServiceIntegrationSpec extends Specification {

    DemandeService demandeService

    void "test de traitement de demande de visite  d'un musee"() {

        given:"un musee"
        Adresse adresse1 =  new Adresse(numeroA: "2", rue: "rue",ville: "Albi",codePostal: "81000")


        and:"un gestionnaire"
        Gestionnaire gestion= new Gestionnaire(nom: "Doo")

        when: "on tente de répercuter en base la création ou la modification de musee"


        Musee unMusee = new Musee(nom:"un nom", horairesOuverture: "10h",telephone: "02 47 85 64 85",accesMetro: "Jean Jaures",site: "www.albi.fr",gestionnaire: gestion, adresse: adresse1,favori: "oui")

        adresse1.save(flush: true)

        gestion.save(flush: true)


        then: "On tente de faire un traitement de demande"
      String demandeservice= demandeService.traiterDemande(unMusee.nom.toString(),"10/10/2015","13/10/2015","3")

        and:"On tente de vérifier que le resultat n'est pas nul"
        demandeservice.toString()!=null


    }
}
