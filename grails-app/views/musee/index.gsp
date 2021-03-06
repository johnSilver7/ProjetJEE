<%@ page import="projetjee.Musee" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                                  args="[entityName]"/></g:link></li>
        </ul>
    </div>

    <div id="list-musee" class="content scaffold-list" role="main">
        <h1><g:message code="default.list.label" args="[entityName]"/></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <g:form>
            <fieldset class="form">
                <div class="fieldcontain">
                    <label for="nom">
                        Le nom du musee contient :
                    </label>
                    <g:textField name="nom"/>
                    <label for="code">
                        Le code postal est :
                    </label>
                    <g:select id="code" name="code" from="${projetjee.Adresse.listUnique()}"
                              noSelection="${['null': 'Select one...']}"></g:select>
                </div>


                <div class="fieldcontain">
                    <label for="rue">
                        Le nom de la rue contient :
                    </label>
                    <g:textField name="rue"/>
                </div>

                <div style="float: right">
                    <g:actionSubmit action="doSearchMusees" value="Rechercher"/>
                </div>
            </fieldset>

        </g:form>
        <table>
            <thead>
            <tr>

                <g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}"/>

                <g:sortableColumn property="horairesOuverture"
                                  title="${message(code: 'musee.horairesOuverture.label', default: 'Horaires Ouverture')}"/>

                <g:sortableColumn property="telephone"
                                  title="${message(code: 'musee.telephone.label', default: 'Telephone')}"/>

                <g:sortableColumn property="accesMetro"
                                  title="${message(code: 'musee.accesMetro.label', default: 'Acces Metro')}"/>

                <th><g:message code="musee.adresse.label" default="Adresse"/></th>

                <g:sortableColumn property="site" title="${message(code: 'musee.site.label', default: 'Site')}"/>

            </tr>
            </thead>
            <tbody>
            <g:each in="${museeInstanceList}" status="i" var="museeInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show"
                                id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nom")}</g:link></td>

                    <td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>

                    <td>${fieldValue(bean: museeInstance, field: "telephone")}</td>

                    <td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>

                    <td>${fieldValue(bean: museeInstance, field: "adresse")}</td>

                    <td>${fieldValue(bean: museeInstance, field: "site")}

                    <g:form>
                        <g:if test="${"${museeInstance.favori}" == "oui"}">
                            <g:actionSubmit value="bookmark me!" disabled="true"/>
                        </g:if>
                        <g:else>
                            <g:hiddenField name="nom" value="${museeInstance.nom}"/>
                            <g:actionSubmit action="addFavorites" value="bookmark me!"/>
                        </g:else>
                    </g:form>

                </tr>
            </g:each>
            </tbody>
        </table>

        <div class="pagination">
            <g:paginate total="${museeInstanceCount ?: 0}"/>
        </div>
    </div>
    <g:if test="${"${ showFav }" == "ok"}">

        <div>
            <h1>MES MUSEES FAVORIS</h1>
            <g:each in="${museeInstanceList}" status="i" var="museeInstance">
                <g:if test="${"${museeInstance.favori}" == "oui"}">
                    <table>
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td><g:link action="show"
                                        id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nom")}</g:link>
                            <g:form>
                                <g:hiddenField name="nom" value="${museeInstance.nom}"/>
                                <g:actionSubmit action="removeFavorites" value="Supprimer des favoris"/>
                                <g:actionSubmit action="redirectToDemandeVisite" value="Demande visite"/>
                            </g:form>
                            </td>
                        </tr>
                    </table>

                </g:if>
            </g:each>
        </div>
    </g:if>
</body>
</html>
