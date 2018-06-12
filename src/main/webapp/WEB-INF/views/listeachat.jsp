<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="row">


	<p>${resultat }</p>
	<div class="row">
		<f:form class="col s12 m12 l12 white">
			<legend>
				<h5>Liste des Achats</h5>
			</legend>
			<div class="col s12 l12">
				<div>
					<table class="striped bordered highlight centered white recherche">
						<thead>
							<tr>
								<th>Numéro de l' Achat</th>
								<th>Numéro de la Commande</th>
								<th>Numéro de la Article</th>
								<th>Numéro de la Facture</th>
								<th>Quantité</th>
								<th>Montant</th>
								<th>TVA</th>
								<th>Remise</th>
								<!-- <th>Action</th> -->
							</tr>
						</thead>
						<c:forEach items="${facturelist}" var="facturelist">
							<tr>
								<td>${facturelist.achatId }</td>
								<td>${facturelist.commande.commandeId}</td>
								<td>${facturelist.article.articleId}</td>
								<td>${facturelist.facture.factureId}</td>
								<td>${facturelist.quantite}</td>
								<td>${facturelist.montantHt }</td>
								<td>${facturelist.tva }</td>
								<td>${facturelist.remise }</td>
								<%-- <td><a
									href="editFacture?factureId=${facturelist.factureId}">Modification</a>
									<a href="deleteFacture?factureId=${societelist.factureId}">Supprimer</a></td> --%>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</f:form>
	</div>
	<a href="<%=request.getContextPath()%>/FactureDroit/validationAchat"
		type="submit" name="action">
		<button class="btn waves-effect waves-light">
			Validation de l'achat <i class="material-icons left">chevron_right</i>
		</button>
	</a>
	<div class="row">
		<button></button>

	</div>

</div>
<%@include file="footer.jsp"%>