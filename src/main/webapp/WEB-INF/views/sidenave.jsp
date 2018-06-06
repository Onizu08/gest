
<div id="modal1" class="modal">
	<div class="row">
		<form class="col s12 m10 l8 offset-l3">
			<div class="row">
				<div class="col s12 m10 l8">
					<div class="input-field col s10 m10 l12">
						<i class="material-icons prefix">account_circle</i> <input
							id="icon_prefix" type="text" class="validate"> <label
							for="icon_prefix">User Name</label>${user}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m10 l8">
					<div class="input-field col s10 m10  l12">
						<i class="material-icons prefix">lock</i> <input id="icon_lock"
							type="password" class="validate"> <label for="icon_lock">Password</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m8 l6">
					<button class="btn waves-effect waves-light " type="submit"
						name="action">
						AUTHENTIFICATION<i class="material-icons right">done</i>
					</button>
				</div>
				<div class="col s12 m8 l6">
					<button class="btn waves-effect waves-light red lighten-1 right"
						type="reset" name="action">
						Reset<i class="material-icons right">replay</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
<ul id="slide-out" class="side-nav">
	<li>
		<div class="userView">
			<img class="background" src="images/office.jpg"> <a
				href="#!user"><i class="material-icons left">perm_identity</i>${user}</a>
			<a href="#!name"><span class="white-text name">John Doe</span></a> <a
				href="#!email"><span class="white-text email">jdandturk@gmail.com</span></a>
		</div>
	</li>
	<!-- Modal Structure -->
	<ul>
		<ol class="waves-effect">
			GESTION DE FACTURE
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/">Accueil</a></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Client/index">Gestion de
					Client</a></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Societe/index">Gestion de
					Société</a></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Commande/index">Gestion de
					Commande</a></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Achat/index">Gestion d'Achat
			</a></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Facture/facture">Gestion de
					Facture </a></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Payement/index">Gestion de
					Payement </a></li>
		</ol>
	</ul>
	<li><a class="waves-effect red lighten-1"
		href="<%=request.getContextPath()%>/login"><i
			class="material-icons left">power_settings_new</i>Déconnexion</a></li>
</ul>