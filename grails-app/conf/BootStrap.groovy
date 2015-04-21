import projetjee.JeuTestService

class BootStrap {

    JeuTestService jeuTestService
    def init = { servletContext ->

            jeuTestService.createJeuTestforMusee()

        }
        def destroy = {
        }
    }
