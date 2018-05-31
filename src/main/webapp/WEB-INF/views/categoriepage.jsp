<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="row">
	<f:form class="col s12 m8 l5 offset-l4 white"
		modelAttribute="categorie" action="saveCategorie" method="post">
		<legend>
			<h4>Information Catégorie</h4>
		</legend>
		<div class="input_fields_wrap">
			<div class="row" id="1">
				<div class="input-field col s12 m8 l5">
					<f:input path="categorieId" type="text" class="validate"
						readonly="true" />
					<label for="categorieId">Categorie Id:</label>
				</div>
				<div class="input-field col s12 m8 l5">
					<f:input path="categorieLib" type="text" class="validate" />
					<label for="categorieLib">Categorie Libelle :</label>
				</div>
				<div class="input-field col s12 m8 l5">
					<f:input path="promoCategorie" type="text" class="validate" />
					<label for="promoCategorie">Promotion Categorie :</label>
				</div>
				<div class="input-field col s12 m8 l5">
					<f:input path="categorieDescription" type="text" class="validate" />
					<label for="categorieDescription">Description Categorie :</label>
				</div>
			</div>
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
	<span>${error}</span>
</div>
<div class="row">
	<f:form class="col s12 m12 l12 white">
		<legend>
			<h5>Liste des Categories</h5>
		</legend>
		<div class="col s12 l12">
			<div>
				<table class="striped bordered highlight centered white"
					id="recherche">
					<thead>
						<tr>
							<th>ID Categorie</th>
							<th>LIB Categorie</th>
							<th>Promotion</th>
							<th>Description</th>
							<th>Action</th>
						</tr>
					</thead>
					<c:forEach items="${categorielist}" var="deviselist">
						<tr>
							<td>${deviselist.categorieId}</td>
							<td>${deviselist.categorieLib}</td>
							<td>${deviselist.promoCategorie}</td>
							<td>${deviselist.categorieDescription}</td>
							<td><a
								href="editCategorie?categorieId=${deviselist.categorieId}">Modification</a></td>
							<td><a
								href="deleteCategorie?categorieId=${deviselist.categorieId}">Supprimer</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</f:form>
</div>

<%@include file="footer.jsp"%>