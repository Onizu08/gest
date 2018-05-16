<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="reduction"
	action="saveReduction" method="post">
	<legend>
		<h4>Information Article</h4>
	</legend>
	<div class="input_fields_wrap">
		<div class="row" id="1">
			<div class="input-field col s12 m8 l2">
				<f:input path="reductionId" type="text" class="validate"
					readonly="true" />
				<label for="reductionId">Reduction Id:</label>
			</div>
			<div class="input-field col s12 m8 l5">
				<f:input path="reductionLib" type="text" class="validate" />
				<label for="reductionLib">Libelle Reduction</label>
			</div>
			<div class="input-field col s12 m8 l5">
				<f:input path="reductionApplique" type="text" class="validate" />
				<label for="reductionApplique">Reduction Applique :</label>
			</div>
			<div class="input-field col s12 m8 l5">
				<f:input path="reductionDescription" type="text" class="validate" />
				<label for="reductionDescription">Reduction Description :</label>
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
						<th>Id Reduction</th>
						<th>Libelle</th>
						<th>Applique</th>
						<th>Description</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach items="${reductionlist}" var="villelist">
					<tr>
						<td>${villelist.reductionId }</td>
						<td>${villelist.reductionLib }</td>
						<td>${villelist.reductionApplique }</td>
						<td>${villelist.reductionDescription }</td>
						<td><a
							href="editReduction?reductionId=${villelist.reductionId}">Modification</a></td>
						<td><a
							href="deleteReduction?reductionId=${villelist.reductionId}">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</f:form>
</div>
