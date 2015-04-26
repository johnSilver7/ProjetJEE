package projetjee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"() {

        given: "un gestionnaire initialise avec des paramètres non vide"
        Gestionnaire gestion = new Gestionnaire(nom: "un nom")

        expect: "le gestionnaire est valide"
        gestion.validate() == true

    }

    @Unroll
    void "test l'invalidite d'un gestionnaire non valide"() {

        given: "un gestionnaire initialise avec les paramètres vides"
        Gestionnaire gestion = new Gestionnaire()

        expect: "l'adresse est invalide"
        gestion.validate() == false


    }

    @Unroll
    void "test la fonction toString"() {

        given:
        "un gestionnaire initialise avec un nom"
        Gestionnaire gestion = new Gestionnaire(nom: "unNom")


        expect: "l'adresse est invalide"
        gestion.toString() == "unNom"
    }
}
