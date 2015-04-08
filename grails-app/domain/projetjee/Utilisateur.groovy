package projetjee

class Utilisateur {

    String nom
    String prenom
    String sexe
    Date dateNaissance
    String email

    String toString() {
        "$prenom $nom"
    }
    static constraints = {
        nom blank: false
        prenom blank: false
        sexe inList: ["F","M"]
        dateNaissance nullable: true
        email email: true
    }
}
