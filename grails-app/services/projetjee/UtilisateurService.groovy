package projetjee

import grails.transaction.Transactional

@Transactional
class UtilisateurService {

    def ajoutFavoris(Musee musee) {
       Gestionnaire.get(0).listFavoris.add(musee).save(flush: true)
        Gestionnaire.get(0).unMusee = "ouiii"
        Gestionnaire.get(0).save(flush: true)

    }
}
