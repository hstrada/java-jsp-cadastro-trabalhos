<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card card-plain">
			<div class="header">
				<h4 class="title">Escolas</h4>
				<p class="category">Listagem de escolas cadastradas</p>
			</div>
			<div class="content table-responsive table-full-width">
				<jsp:useBean id="escola" class="br.com.ct.bean.EscolasBean"
					scope="page" />
				<table class="table table-hover">
					<thead>
						<th>ID</th>
						<th>Nome</th>
					</thead>
					<tbody>
						<c:forEach var="escola" items="${escola.listaEscolas }">
							<tr>
								<td>${escola.id }</td>
								<td>${escola.nome }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>

<jsp:include page="../template/footer.jsp" />