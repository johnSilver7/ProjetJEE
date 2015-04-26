package projetjee


import spock.lang.*

/**
 *
 */
class MuseeServiceIntegrationSpec extends Specification {


    MuseeService MuseeService

    void "test insertion ou mise à jour d'un musee"() {

        given:"un musee"
        Adresse adresse1 =  new Adresse(numeroA: "2", rue: "rue",ville: "Albi",codePostal: "81000")


        Musee unMusee = new Musee(nom:"un nom", horairesOuverture: "10h",telephone: "02 47 85 64 85",accesMetro: "Jean Jaures",site: "www.albi.fr",adresse: adresse1,favori: "oui")

        adresse1.save(flush: true)

        and:"un gestionnaire"
        Gestionnaire gestion= new Gestionnaire(nom: "Doo")

        when: "on tente de répercuter en base la création ou la modification de musee"
        Musee resultMusee = MuseeService.insertOrUpdateMuseeForGestionnaire(unMusee,gestion)


        then: "lle musee resultant pointe sur le inital"
        resultMusee == unMusee

        and:"le résultant n'a pas d'erreur"
        !resultMusee.hasErrors()

        and:"le musee résultant a un id"
        resultMusee.id

        and:"le est bien present en base"
        MuseeService.searchUnMusee(resultMusee.nom) != null

        and:"le est bien present en base avec l'adresse"
        MuseeService.searchMusees(resultMusee.nom,resultMusee.adresse.codePostal,resultMusee.adresse.rue)

        and: "le musee a une adresse et un gestionnaire passé en paramètre"

        resultMusee.gestionnaire==gestion

        and:"le gestionnaire a dans sa liste de musée le musee passé en paramètre"
        println ">>>>>>> classe pour musees : ${gestion.musees.class.name}"
        gestion.musees.contains(resultMusee)

        and:"Ajout aux favoris"
        List<Musee> listeMusee=MuseeService.ajoutFavori(resultMusee.nom)

    }


}
