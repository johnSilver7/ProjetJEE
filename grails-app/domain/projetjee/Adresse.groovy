package projetjee

class Adresse {


    String numeroA
    String rue
    String ville
    String codePostal

    String toString() {
        "$numeroA $rue $ville $codePostal"
    }

    static constraints = {

        numeroA blank: false,nullable: false
        rue blank: false,nullable: false
        ville blank: false,nullable: false
        codePostal blank: false,nullable: false
    }
}
