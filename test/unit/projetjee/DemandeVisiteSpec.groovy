package projetjee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    String codeD
    String dateDebutPeriode
    String dateFinPeriode
    int nbPersonnes
    String status

    @Unroll
    void "test la validite d'une DemandeVisite valide"() {

        given: "une DemandeVisite initialise avec des paramètres non vides"
        DemandeVisite demande = new DemandeVisite(codeD: "un code", dateDebutPeriode: "une datedebut", dateFinPeriode: "une datefin", status: "status",nbPersonnes: 5)

        expect: "la DemandeVisite est valide"
        demande.validate() == true




    }

    @Unroll
    void "test l'invalidite la DemandeVisite non valide"(String uncode, String uneDDebut, String uneDFin, String  unstatus) {

        given: "une DemandeVisite initialise avec les paramètres vides"
        DemandeVisite demande = new DemandeVisite(codeD: uncode,dateDebutPeriode: uneDDebut,dateFinPeriode: uneDFin,status: unstatus)

        expect: "la DemandeVisite est invalide"
        demande.validate() == false

        where:
        uncode   | uneDDebut | uneDFin | unstatus
        null     |  null     | null    | null
        ""       | ""        | ""      |""


    }
}
