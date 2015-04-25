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

    List<Gestionnaire> searchGestionnaire(String nomG) {
        def criteria = Gestionnaire.createCriteria()
        List<Gestionnaire> res = criteria.list {
            if (nomG) {
                ilike 'nom', "${nomG}"
            }
            order('nom')
        }
        res
    }


    List<Musee> ajoutFavori(String nom) {
        // Musee leMusee = Musee.findByNom(nom)

        List<Musee> unMusee = searchUnMusee(nom)
        List<Gestionnaire> unGestionnaire = searchGestionnaire("gestionnaire favoris")
        unMusee.first().setFavori("oui")
        unMusee.first().save(flush: true, failOnError: true)
        unGestionnaire.first().addToMusees(unMusee.first())
        unGestionnaire.first().save(flush: true, failOnError: true)
        unMusee
    }

    List<Musee> deleteFavori(String nom) {
        // Musee leMusee = Musee.findByNom(nom)

        List<Musee> unMusee = searchUnMusee(nom)
        List<Gestionnaire> unGestionnaire = searchGestionnaire("gestionnaire favoris")
        unMusee.first().setFavori("non")
        unMusee.first().save(flush: true, failOnError: true)
        unGestionnaire.first().removeFromMusees(unMusee.first())
        unGestionnaire.first().save(flush: true, failOnError: true)
        unMusee
    }


}
