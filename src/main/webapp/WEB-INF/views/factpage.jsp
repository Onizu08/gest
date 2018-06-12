<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%><div class="container">
	<div class="row">
		<div class="col s12 m12 l12">
			<div class="row">
				<div class="col s12 m12 l12">
					<div class="row">
						<div class="col s12 m12 l6">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/gestionFormations.svg">
									<div class="contenue">
										<span class="mot activator white-text">Facture de droit</span>
									</div>
									<figcaption>
										<h2 class="title">Facture de droit</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l3">
															<div class="tri-action">
																<div class="col s12 m12 l3">
																	<i class="material-icons left">open_in_new</i> <a
																		href="<%=request.getContextPath()%>/Facture/facture/factureDroit/index">Ouvrir</a>
																</div>

															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
						<div class="col s12 m12 l6">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/gestionFormations.svg">
									<div class="contenue">
										<span class="mot activator white-text">Facture d'avoir</span>
									</div>
									<figcaption>
										<h2 class="title">Facture d'avoir</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l3">
															<div class="tri-action">
																<div class="col s12 m12 l3">
																	<i class="material-icons left">open_in_new</i> <a
																		href="<%=request.getContextPath()%>/Facture/facture/factureAvoir/index">Ouvrir</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>