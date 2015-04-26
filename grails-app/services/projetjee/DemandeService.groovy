package projetjee

import grails.transaction.Transactional

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

@Transactional
class DemandeService {

    DemandeVisite uneDemande
    DemandeVisiteMusee demandeVisite
    MuseeService museeService

    String traiterDemande(String musee, String dateDebut, String dateFin, String nbPersonne) {
        String erreur

        if (!dateDebut || !dateFin || dateDebut == 'null' || dateFin == 'null') {
            erreur = 'err_date'
            return erreur

        }

        if (dateDebut.length() > 10 || dateFin.length() > 10 ) {
            erreur = 'err_date'
            return  erreur
        }

        Date date1
        Date date2
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        try {
            date1 = df.parse(dateDebut);
            date2 = df.parse(dateFin)
        } catch (ParseException pe) {
            erreur = 'err_date'
            return erreur
        }
        Date today = new Date()

        if (date1 < today || date2 < today || date1 > date2) {
            erreur = 'err_date'
            return erreur
        }

        if(!nbPersonne.isInteger()) {
            erreur = 'err_pers'
            return  erreur
        }

        if (nbPersonne == 'null' || !nbPersonne || nbPersonne.toInteger() > 6 || nbPersonne.toInteger() <= 0) {
            erreur = 'err_pers'
            return erreur
        }


        String randomString = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(12)

        uneDemande = new DemandeVisite(
                codeD: randomString,
                dateDebutPeriode: dateDebut,
                dateFinPeriode: dateFin,
                nbPersonnes: nbPersonne,
                status: "en cours de traitement"
        ).save(flush: true)

        List<Musee> unMusee = museeService.searchUnMusee(musee)
        String date = today.toString()
        demandeVisite = new DemandeVisiteMusee(
                dateDemande: date,
                demandeVisite: uneDemande,
                musee: unMusee.first()).save(flush: true)

        erreur = "ras"
        erreur

    }
}
