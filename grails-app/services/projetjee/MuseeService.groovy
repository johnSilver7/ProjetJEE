package projetjee

import grails.transaction.Transactional

@Transactional
class MuseeService {

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
            if (code) {
                adresse {
                    ilike 'codePostal', "%${code}%"
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

}
