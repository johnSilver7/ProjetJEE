package projetjee


import spock.lang.*

/**
 *
 */
class JeuTestServiceIntegrationSpec extends Specification {

    JeuTestService jeuTestService

    void "test creation jeu de tests pour activités"() {

        Musee.count() == 0

        when: "on crée le jeu de test pour les activite"
        jeuTestService.createJeuTestforMusee()

        then: "6 nouveaux musees ont été crées en base"
        Musee.count() == 6


        when:" des musees exitent deja dans la base"
        Musee.count() == 6

        and:"on déclenche à nouveau la création du jeu de test pour amusee"
        jeuTestService.createJeuTestforMusee()

        then:"aucun nouveau musee n'est crée"
        Musee.count() == 6

    }
}
