package projetjee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    Musee insertOrUpdateMuseeForGestionnaire(Musee unMusee, Gestionnaire unGestionnaire) {
        unGestionnaire.addToMusees(unMusee)
        unGestionnaire.save(flush: true)
        unMusee
    }

    Musee insertOrUpdateMuseeForAdresse(Musee unMusee, Adresse uneAdresse) {
        unMusee.setAdresse(uneAdresse)
        unMusee
    }
}
