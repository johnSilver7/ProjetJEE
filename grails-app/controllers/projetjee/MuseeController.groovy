package projetjee


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {

    MuseeService museeService

    static scaffold = true

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index = {
        ['val': 0] //or [val: params.val] if you want to get it from parameters.
    }

    def addFavorites() {
        def showFav = "ok"
        def listFavoris = museeService.ajoutFavori(params.nom)
        render(view: 'index', model: [museeInstanceList: Musee.list(), museeInstanceCount: Musee.count(), showFav : showFav])
    }

    def redirectToDemandeVisite =  {
        redirect(controller:"demandeVisiteMusee",action:"index")
    }

    def removeFavorites() {
        def showFav = "ok"
        def listremove = museeService.deleteFavori(params.nom)
        render(view: 'index', model: [museeInstanceList: Musee.list(), museeInstanceCount: Musee.count(), showFav : showFav])
    }

    def doSearchMusees() {
        def showFav = "non"
        def museeList = museeService.searchMusees(params.nom, params.code, params.rue)
        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.size(), showFav: showFav])
    }

    def index(Integer max) {
        def showFav = "ok"
        params.max = Math.min(max ?: 10, 100)
        respond Musee.list(params), model: [museeInstanceCount: Musee.count(), showFav: showFav]
    }

    def show(Musee museeInstance) {
        respond museeInstance
    }

    def create() {
        respond new Musee(params)
    }

    @Transactional
    def save(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view: 'create'
            return
        }

        museeInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*' { respond museeInstance, [status: CREATED] }
        }
    }

    def edit(Musee museeInstance) {
        respond museeInstance
    }

    @Transactional
    def update(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view: 'edit'
            return
        }

        museeInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*' { respond museeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Musee museeInstance) {

        if (museeInstance == null) {
            notFound()
            return
        }

        museeInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musee.label', default: 'Musee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
