<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<title>GESTION RESSOURCES HUMAINES</title>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/materialize.min.css"
	media="screen,projection" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-material-datetimepicker.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="<%=request.getContextPath()%>/resources/css/materialdesignicons.min.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/dataTables.material.min.css" />

<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.min.css" />

<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/fixedColumns.dataTables.min.css" />



<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="utf-8" />

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$('.typeClientCoordonnees').hide();
		$('#clientParticulier').show();

		$('#typeClient').on("change", function() {
			$('.typeClientCoordonnees').hide();
			$('#client' + $(this).val()).show();
		}).val("clientParticulier");
	});
</script>
</head>
<body>
	<header>
		<div class="row">
			<div class="col s3 m4 l1">
				<a href="#" data-activates="slide-out"
					class="button-collapse show-on-large"> <ia
						class="material-icons">menu</ia>
				</a>
			</div>
			<div class="col s12 m12 l12">
				<img src="<%=request.getContextPath()%>resources/img/logo.svg">
			</div>
		</div>
	</header>
	<main>