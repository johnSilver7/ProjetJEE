package projetjee

import grails.transaction.Transactional

@Transactional
class MuseeService {
    JeuTestService jeu = new JeuTestService()

    Musee insertOrUpdateMuseeForGestionnaire(Musee unMusee, Gestionnaire unGestionnaire) {
        unGestionnaire.addToMusees(unMusee)
        unGestionnaire.save(flush: true)
        unMusee
    }


    List<Musee> searchMusees(String nomMusee, String code, String rue) {
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list {
            if (nomMusee) {
                ilike 'nom', "%${nomMusee}%"
            }
            if (code != 'null') {
                adresse {
                    ilike 'codePostal', "${code}"
                }

            }
            if (rue) {
                adresse {

                    ilike 'rue', "%${rue}%"
                }
            }
            adresse {
                order('rue')
            }
            join 'adresse'
        }
        res
    }

    List<Musee> searchUnMusee(String nomMusee) {
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list {
            if (nomMusee) {
                ilike 'nom', "${nomMusee}"
            }
            order('nom')
        }
        res
    }


    List<Musee> ajoutFavori(String nom) {
        // Musee leMusee = Musee.findByNom(nom)
        Gestionnaire gestionnaire;

        List<Musee> unMusee = searchUnMusee(nom)
        unMusee.first().setFavori("oui")
        unMusee.first().save(flush: true)
        unMusee.first().gestionnaire.removeFromMusees(unMusee.first())

        gestionnaire = new Gestionnaire(
                nom: "Gestionnaire des musees de Toulouse"
        )

        insertOrUpdateMuseeForGestionnaire(unMusee.first(),gestionnaire)
        //jeu.supprimerDuGestionnnaire(new Musee(nom: "archives"))
        //insertOrUpdateMuseeForGestionnaire(unMusee.first(), jeu.gestionnaireMusee)

        //jeu.gestionnaireMusee.removeFromMusees(unMusee.first())
        //unMusee.get(0).gestionnaire.save(flush: true)
        unMusee

    }


}
