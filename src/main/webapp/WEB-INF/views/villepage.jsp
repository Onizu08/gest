<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<div class="row">
	<div class="col s12 l12 ">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="ville"
				action="saveVille" method="post">
				<legend>
					<h4>Information Ville</h4>
				</legend>
				<div class="row">
					<div class="col s12 m8 l12 offset-l2">
						<div class="input-field col s12 m8 l4">
							<f:select path="pays.paysId" items="${paylist}"
								itemValue="paysId" itemLabel="paysId" id="paysId">
							</f:select>
							<label>Pays Id</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col s12 m8 l12 offset-l2">
						<div class="input-field col s12 m8 l6">
							<f:input path="idVille" type="text" class="validate" />
							<label for="idVille">Ville Id:</label>
						</div>
					</div>
					<div class="col s12 m8 l12 offset-l2">
						<div class="input-field col s12 m8 l6">
							<f:input path="libVille" type="text" class="validate" />
							<label for="libVille">Ville Libelle :</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col s12 m12 l12">
						<div class="col s12 m7 l5">
							<button class="btn waves-effect waves-light " type="submit"
								name="action">
								Sauvegarder<i class="material-icons right">done</i>
							</button>
						</div>
						<div class="col s12 m7 l4 ">
							<button class="btn waves-effect waves-light red lighten-1 right"
								type="reset" name="action">
								Annuler<i class="material-icons right">replay</i>
							</button>
						</div>
					</div>
				</div>
			</f:form>
		</div>
	</div>
</div>
<span>${error}</span>
<div>
	<table class="striped bordered highl ight centered white"
		id="recherche">
		<thead>
			<tr>
				<th>Id Ville</th>
				<th>Nom Ville</th>
				<th>Id Pays</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${villelist}" var="villelist">
				<tr>
					<td>${villelist.idVille }</td>
					<td>${villelist.libVille }</td>
					<td>${villelist.pays.paysId }</td>
					<td><a href="editVille?idVille=${villelist.idVille}">Modification</a>
						<a href="deleteVille?idVille=${villelist.idVille}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div><%@include file="footer.jsp"%>