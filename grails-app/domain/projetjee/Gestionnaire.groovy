package projetjee

class Gestionnaire {

    String nom


    static hasMany = [musees:Musee]
    static constraints = {
        nom blank: false,nullable: false
    }
}
