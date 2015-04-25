<%@ page import="projetjee.Musee" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <g:javascript library="scriptaculous" />
    <g:javascript>

        window.
        $(document).ready(function () {




            $("#sub").click(function() {

            $("#idtab").show();
        });

        });
    </g:javascript>
</head>

<body>
<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

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
                <g:select name="code" from="${projetjee.Adresse.list()}" optionKey="codePostal" optionValue="codePostal"></g:select>
            </div>


            <div class="fieldcontain">
                <label for="rue">
                    Le nom de la rue contient :
                </label>
                <g:textField name="rue"/>
            </div>

            <div style="float: right">
                <g:actionSubmit id="sub" action="doSearchMusees" value="Rechercher"/>
            </div>
        </fieldset>

    </g:form>

    <div id="idtab">
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


                    <g:if test="${fieldValue(bean: museeInstance, field: "favori") == "oui"}">
                        <button type="button" name="favButton" disabled = true >bookmark me!</button>
                    </g:if>
                    <g:else>
                        <button type="button" name="favButton"
                                onclick="${remoteFunction(action: 'addFavorites', controller: 'MuseeController',
                                        params: [musee : museeInstance])}") >bookmark me!</button>
                    </g:else>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate max="0" total="${museeInstanceCount ?: 0}"/>
    </div>
    </div>
</div>
</body>
</html>