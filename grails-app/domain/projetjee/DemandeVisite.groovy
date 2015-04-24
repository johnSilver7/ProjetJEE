package projetjee

class DemandeVisite {

    String codeD
    String dateDebutPeriode
    String dateFinPeriode
    int nbPersonnes
    String status

    static constraints = {
        codeD blank: false,nullable: false
        dateDebutPeriode blank: false,nullable: false
        dateFinPeriode blank: false,nullable: false
        status blank: false,nullable: false
    }
}
