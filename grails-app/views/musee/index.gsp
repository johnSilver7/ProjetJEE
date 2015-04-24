<%@ page import="projetjee.Musee" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <meta charset="UTF-8">
    <g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
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
                <g:textField name="code"/>
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
    </table>

    <div class="pagination">
        <g:paginate total="${museeInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>