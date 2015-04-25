
<%@ page import="projetjee.DemandeVisiteMusee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demandeVisiteMusee.label', default: 'DemandeVisiteMusee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-demandeVisiteMusee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-demandeVisiteMusee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

			<g:if test="${"${erreur}" == "err_date"}">
				<div class="message" role="status">ERREUR, les dates doivent etre de format aaaa.mm.jj,
				posterieures a aujourd'hui et la date de debut anterieure a la date de fin</div>
			</g:if>



			<g:if test="${"${erreur}" == "err_pers"}">
				<div class="message" role="status">ERREUR, le nombre maximum de visiteur est de 6</div>
			</g:if>

			<g:form>
				<fieldset class="form">

					<div class="fieldcontain">

						<g:select id="nom" name="nom" from="${projetjee.Musee.findAllByFavori('oui')}" optionKey="nom" required=""
								  value="${demandeVisiteMuseeInstance?.musee?.nom}" class="many-to-one"/>
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

			<g:if test="${"${erreur}" == "ras"}">
				<div class="message" role="status">Votre demande a bien ete enregistree et sera traitee bientot. Retrouvez votre code de demande ci-dessous</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateDemande" title="${message(code: 'demandeVisiteMusee.dateDemande.label', default: 'Date Demande')}" />

						<th><g:message code="CodeD" default="codeD" /></th>

						<th><g:message code="demandeVisiteMusee.musee.label" default="Musee" /></th>
					
						<th><g:message code="demandeVisiteMusee.demandeVisite.label" default="Status" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${demandeVisiteMuseeInstanceList}" status="i" var="demandeVisiteMuseeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${demandeVisiteMuseeInstance.id}">${fieldValue(bean: demandeVisiteMuseeInstance, field: "dateDemande")}</g:link></td>

						<td>${demandeVisiteMuseeInstance.demandeVisite.codeD}</td>

						<td>${fieldValue(bean: demandeVisiteMuseeInstance, field: "musee")}</td>
					
						<td>${demandeVisiteMuseeInstance.demandeVisite.status}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${demandeVisiteMuseeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
