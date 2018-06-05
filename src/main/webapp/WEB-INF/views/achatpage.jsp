<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>

<script type="text/javascript">
	$(function() {
		$("#addMore")
				.click(
						function(e) {
							e.preventDefault();
							$("#formulaire")
									.append(
											"<input type='text' class='validate' name='nomArticle' placeholder='nomArticle'/>");
							$("#formulaire")
									.append(
											"<input type='text' class='validate' name='quantite' placeholder='quantite'/>");
							$("#formulaire")
									.append(
											"<input type='text' class='validate' name='montantHt' placeholder='montantHt'/>");
							$("#formulaire")
									.append(
											"<input type='text' class='validate' name='tva' placeholder='tva'/>");
							$("#formulaire")
									.append(
											"<input type='text' class='validate' name='remise' placeholder='remise'/>");
						});
	});
</script>
<div class="row">
	<div class="row">
		<div class="row">
			<a href="<%=request.getContextPath()%>/Commande/index">
				<button class="btn waves-effect waves-light">
					COMMANDE <i class="material-icons left">chevron_left</i>
				</button>
			</a>
		</div>
		<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="achat"
			action="saveAchat" method="post">
			<legend>
				<h4>Information de l'Achat</h4>
			</legend>
			<div class="input_fields_wrap">
				<div class="row" id="formulaire">
					<div class="input-field col s12 m8 l5">
						<f:select path="commande.commandeId" items="${commandelist}"
							itemValue="commandeId" itemLabel="commandeId" name="commandeId"></f:select>
						<label for="commandeId">Numéro de la commande</label>
					</div>
					<div class="input-field col s12 m8 l5">
						<f:select path="article.articleId" items="${articlelist}"
							itemValue="articleId" itemLabel="nomArticle" name="nomArticle"
							placeholder="nomArticle"></f:select>
						<label for="commandeId">Nom de l'article</label>
					</div>
					<div class="input-field col s12 m8 l5">
						<f:select path="facture.factureId" items="${facturelist}"
							itemValue="factureId" itemLabel="factureId" name="factureId"></f:select>
						<label for="commandeId">Numéro de facture</label>
					</div>
					<div class="input-field col s12 m8 l5">
						<f:input path="quantite" type="text" class="validate"
							name="quantite" placeholder="quantite" />
						<label for="quantite">Quantite</label>
					</div>
					<div class="input-field col s12 m8 l5">
						<f:input path="montantHt" type="text" class="validate"
							name="montantHt" placeholder="montantHt" />
						<label for="montantHt">Montant:</label>
					</div>
					<div class="input-field col s12 m8 l5">
						<f:input path="tva" type="text" class="validate" name="tva"
							placeholder="tca" />
						<label for="tva">TVA:</label>
					</div>
					<div class="input-field col s12 m8 l5">
						<f:input path="remise" type="text" class="validate" name="remise"
							placeholder="remise" />
						<label for="remise">Remise:</label>
					</div>
				</div>
			</div>
			<div class="row">
				<button class="btn waves-effect waves-light" id="addMore">Add
					more fields</button>
			</div>
			<div class="row">
				<div class="col s12 m12 l12">
					<div class="col s12 m7 l3">
						<button class="btn waves-effect waves-light " type="submit"
							name="action">
							Sauvegarder<i class="material-icons right">done</i>
						</button>
					</div>
					<div class="col s12 m7 l2 offset-l5 ">
						<button class="btn waves-effect waves-light red lighten-1 right"
							type="reset" name="action">
							Annuler<i class="material-icons right">replay</i>
						</button>
					</div>
				</div>
			</div>
		</f:form>

		<div class="row">
			<a href="<%=request.getContextPath()%>/Facture/index">
				<button class="btn waves-effect waves-light">
					Facture <i class="material-icons right">chevron_right</i>
				</button>
			</a>
		</div>
	</div>
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