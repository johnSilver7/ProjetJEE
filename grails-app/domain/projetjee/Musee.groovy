package projetjee

class Musee {

    String nom
    String horairesOuverture
    String telephone
    String accesBus
    String accesMetro
    Gestionnaire gestionnaire
    Adresse adresse

    static constraints = {

        nom blank:false,nullable:false
        horairesOuverture blank: false,nullable: false
        telephone blank: false,nullable: false
        accesBus blank: false,nullable: false
        accesMetro blank: false,nullable: false
    }
}
