package projetjee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {




    @Unroll
    void "test la validite de la demande de visite au musee valide"() {

        given: "une  demande de visite au musee initialise avec des paramètres non vides"
        DemandeVisiteMusee demande = new DemandeVisiteMusee(dateDemande: "une date de demande", musee: new Musee( nom: "ENSEMBLE CONVENTUEL DE PARIS", horairesOuverture: "Ouvert tous les jours de 9h à 19h.", telephone: "05 61 22 21 20", accesMetro: "Esquirol (A)", site: "www.jacobins.mairie-toulouse.fr", gestionnaire: new Gestionnaire(nom: "Dupont"),adresse: new Adresse( numeroA: "11", rue: "RUE DE ROSSAIRE", ville: "PARIS", codePostal: "81000" ),favori: "non"), demandeVisite: new DemandeVisite(codeD: "2",dateDebutPeriode: "12/07/2015",dateFinPeriode: "17/07/2015",status: "en cours"))

        expect: "la demande de visite au musee est valide"
        demande.validate();

    }

    @Unroll
    void "test l'invalidite d'une  demande de visite au museenon valide"() {

        given: "une  demande de visite au musee initialise avec les paramètres vides"
        DemandeVisiteMusee demande = new DemandeVisiteMusee()

        expect: "la demande de visite au musee est invalide"

        demande.validate() == false


    }
}
