package projetjee

import org.apache.tools.ant.taskdefs.condition.Http

class Musee {

    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String  site
    Gestionnaire gestionnaire
    Adresse adresse
    String favori


    String toString() {
        "$nom"
    }


    static constraints = {

        nom blank:false,nullable:false
        horairesOuverture blank: false,nullable: false
        telephone blank: false,nullable: false
        accesMetro blank: false,nullable: false
        adresse blank:false,nullable: false
        site blank: false,nullable: false
        gestionnaire nullable: true
        favori blank: false, nullable: false
    }

    static mapping = {
        adresse fetch: 'join'
    }
}
