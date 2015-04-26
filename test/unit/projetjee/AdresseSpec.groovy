package projetjee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"() {

        given: "une adresse initialise avec des paramètres non vide"
        Adresse adresse = new Adresse(numeroA: "un numero", rue: "une rue", ville: "une ville", codePostal: "codepostal")

        expect: "l'adresse est valide"
        adresse.validate() == true

    }

    @Unroll
    void "test l'invalidite d'une adresse non valide"(String unNum,String uneRue, String uneVille, String unCode) {

        given: "une adresse initialise avec les paramètres vides"
        Adresse adresse = new Adresse(numeroA: unNum,rue: uneRue,ville: uneVille,codePostal: unCode)

        expect: "l'adresse est invalide"
        adresse.validate() == false

        where:
        unNum   | uneRue | uneVille | unCode
        null   |  null  | null     | null
        ""     | ""     | ""       |""


    }

}
