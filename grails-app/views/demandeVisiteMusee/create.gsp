<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'demandeVisiteMusee.label', default: 'DemandeVisiteMusee')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<a href="#create-demandeVisiteMusee" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="create-demandeVisiteMusee" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${demandeVisiteMuseeInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${demandeVisiteMuseeInstance}" var="error">
                <g:if test="${"${demandeVisiteMuseeInstance.musee.favori}" == "oui"}">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                            error="${error}"/></li>
                </g:if>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form>
        <fieldset class="form">

            <div class="fieldcontain">
                <g:select id="musee" name="musee" from="${projetjee.Musee.findAllByFavori('oui')}" optionKey="id" required=""
                          value="${demandeVisiteMuseeInstance?.musee?.id}" class="many-to-one"/>
            </div>

            <div class="fieldcontain">
                <label for="datedebut">
                    La date de debut est :
                </label>
                <g:textField name="datedebut"/>
            </div>


            <div class="fieldcontain">

                <label for="datefin">
                    La date de fin est :
                </label>
                <g:textField name="datefin"/>
            </div>

            <div class="fieldcontain">

                <label for="nbpers">
                    Nombre de personnes (6 maximum)
                </label>
                <g:textField name="nbpers"/>
            </div>

            <div style="float: right">
                <g:actionSubmit controller = "demandeVisiteMusee" action="faireDemande" value="Enregistrer"/>
            </div>
        </fieldset>

    </g:form>
</div>
</body>
</html>
