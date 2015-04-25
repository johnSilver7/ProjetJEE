package projetjee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {



    @Unroll
    void "test la validite d'un  musee valide"() {

        given: "un musee initialise avec des paramètres non vide"
        Musee musee = new Musee(nom: "un nom", horairesOuverture: "horaire", telephone: "num telephone", accesMetro: "acces", site: "site", gestionnaire: new Gestionnaire(nom: "Dupont"), adresse: new Adresse( numeroA: "11", rue: "RUE DE ROSSAIRE", ville: "PARIS", codePostal: "81000" ), favori: "favori")

        expect: "le musee est valide"
        musee.validate() == true

    }

    @Unroll
    void "test l'invalidite d'une adresse non valide"() {

        given: "un  musee initialise avec les paramètres adresse et gestionnaire vides"
        Musee musee = new Musee(nom: unNom, horairesOuverture: horaire, telephone: phone, accesMetro: metro, site: sit, favori: favo)

        expect: "le musee est invalide"
        musee.validate() == false

        where:
        unNom | horaire | phone | metro | sit  | favo
        null  | null    | null  | null  | null | null
        ""    | ""      | ""    | ""    | ""   | ""


    }

}
