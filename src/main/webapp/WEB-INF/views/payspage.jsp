<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@include file="sidenave.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#addMore")
				.click(
						function(e) {
							e.preventDefault();
							$("#formulaire")
									.append(
											"<input type='text' class='validate' name='paysId' placeholder='paysId'/>");
							$("#formulaire")
									.append(
											"<input type='text' name='paysLib' placeholder='paysLib' />");
						});
	});
</script>
<div class="row">
	<div class="col s12 l12 ">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="test"
				action="savePays" method="post">
				<legend>
					<h4>Information Pays</h4>
				</legend>
				<div class="row" id="formulaire">
					<div class="col s12 m8 l12 offset-l2">
						<div class="input-field col s12 m8 l4">
							<f:input path="paysId" type="text" class="validate" name="paysId"
								placeholder="paysId" />
							<label for="paysId">Pays Id:</label>
						</div>
					</div>
					<div class="row">
						<div class="col s12 m8 l12 offset-l2">
							<div class="input-field col s12 m8 l4">
								<f:input path="paysLib" type="text" class="validate"
									name='paysLib' />
								<label for="paysLib">Pays Libelle :</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<button class="btn waves-effect waves-light" id="addMore">Add
						more fields</button>
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
				<th>ID PAYS</th>
				<th>LIB PAYS</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${payslist}" var="payslis">
			<tr>
				<td>${payslis.paysId}</td>
				<td>${payslis.paysLib}</td>
				<td><a href="editPays?paysId=${payslis.paysId}">Modification</a>
					<a href="deletePays?paysId=${payslis.paysId}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="footer.jsp"%>
