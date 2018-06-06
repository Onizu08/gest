
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="row">
	<div class="row">
		<f:form class="col s12 m12 l12 white">
			<legend>
				<h5>Liste des Achats</h5>
			</legend>
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
							<th>Action</th>
						</tr>
					</thead>
					<c:forEach items="${achatlist}" var="achatlist">
						<tr>
							<td>${achatlist.achatId }</td>
							<td>${achatlist.commande.commandeId}</td>
							<td>${achatlist.article.articleId}</td>
							<td>${achatlist.facture.factureId}</td>
							<td>${achatlist.quantite}</td>
							<td>${achatlist.montantHt }</td>
							<td>${villelist.tva }</td>
							<td>${villelist.remise }</td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</f:form>
	</div>
</div>
<%@include file="footer.jsp"%>
