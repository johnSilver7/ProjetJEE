package projetjee

class DemandeVisiteMusee {

    String dateDemande
    Musee musee
    DemandeVisite demandeVisite

    static constraints = {

        dateDemande blank: false, nullable: false

    }
}
