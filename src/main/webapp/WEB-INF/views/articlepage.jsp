<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="article"
	action="saveArticle" method="post">
	<legend>
		<h4>Information Article</h4>
	</legend>
	<div class="input_fields_wrap">
		<div class="row" id="1">
			<div class="input-field col s12 m8 l2">
				<f:input path="articleId" type="text" class="validate"
					readonly="true" />
				<label for="articleId">Article Id:</label>
			</div>
			<div>
				<f:select path="categorie.categorieId" items="${categorielist}"
					itemValue="categorieId" itemLabel="categorieLib"></f:select>
				<label for="categorieId">Categorie Id</label>
			</div>
			<div class="input-field col s12 m8 l5">
				<f:input path="refArticle" type="text" class="validate" />
				<label for="refArticle">Reference Article</label>
			</div>
			<div class="input-field col s12 m8 l5">
				<f:input path="nomArticle" type="text" class="validate" />
				<label for="nomArticle">Nom Article Categorie :</label>
			</div>
			<div class="input-field col s12 m8 l5">
				<f:input path="prixUnitaire" type="text" class="validate" />
				<label for="prixUnitaire">Prix Unitaire :</label>
			</div>
			<div class="input-field col s12 m8 l5">
				<f:input path="promoArticle" type="text" class="validate" />
				<label for="promoArticle">Promotion Article :</label>
			</div>
			<div class="input-field col s12 m8 l5">
				<f:input path="descriptionArticle" type="text" class="validate" />
				<label for="descriptionArticle">Description Article :</label>
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
<div class="row">
	<f:form class="col s12 m12 l12 white">
		<legend>
			<h5>Liste des Categories</h5>
		</legend>
		<div>
			<table class="striped bordered highlight centered white"
				id="recherche">
				<thead>
					<tr>
						<th>Id Ville</th>
						<th>Categorie</th>
						<th>Reference Article</th>
						<th>Nom Article</th>
						<th>Prix Unitaire Article</th>
						<th>Promotion Article</th>
						<th>Description Article</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach items="${articlelist}" var="villelist">
					<tr>
						<td>${villelist.articleId }</td>
						<td>${villelist.categorie.categorieId }</td>
						<td>${villelist.refArticle }</td>
						<td>${villelist.nomArticle }</td>
						<td>${villelist.prixUnitaire }</td>
						<td>${villelist.promoArticle }</td>
						<td>${villelist.descriptionArticle }</td>
						<td><a href="editArticle?articleId=${villelist.articleId}">Modification</a></td>
						<td><a href="deleteArticle?articleId=${villelist.articleId}">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</f:form>
</div>
