<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<div id="formClient">
	<f:form modelAttribute="ville" action="saveVille" method="post">
		<table>
			<tr>
				<td>Id Ville :</td>
				<td><f:input path="idVille" /></td>
				<td><f:errors path="idVille" /></td>
			</tr>
			<tr>
				<td>Nom Ville :</td>
				<td><f:input path="libVille" /></td>
				<td><f:errors path="libVille" /></td>
			</tr>
			<tr>
				<f:select path="pays.paysId" items="${paylist}" itemValue="paysId"
					itemLabel="paysId"></f:select>
				<label for="paysId">Pays Id</label>
			</tr>
			<tr>
				<td><input type="submit" value="Ajouter"></td>
			</tr>
		</table>
	</f:form>
</div>
<span>${error}</span>
<div>
	<table class="striped bordered highlight centered white" id="recherche">
		<thead>
			<tr>
				<th>Id Ville</th>
				<th>Nom Ville</th>
				<th>Id Pays</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${villelist}" var="villelist">
			<tr>
				<td>${villelist.idVille }</td>
				<td>${villelist.libVille }</td>
				<td>${villelist.pays.paysId }</td>
				<td><a href="editVille?idVille=${villelist.idVille}">Modification</a></td>
				<td><a href="deleteVille?idVille=${villelist.idVille}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
</div>