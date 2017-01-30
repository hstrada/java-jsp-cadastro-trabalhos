<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card card-plain">
			<div class="header">
				<h4 class="title">Cursos</h4>
				<p class="category">Listagem de cursos cadastrados</p>
			</div>
			<div class="content table-responsive table-full-width">
				<jsp:useBean id="curso" class="br.com.ct.bean.CursosBean"
					scope="page" />
				<table class="table table-hover">
					<thead>
						<th>ID</th>
						<th>Nome</th>
					</thead>
					<tbody>
						<c:forEach var="curso" items="${curso.listaCursos }">
							<tr>
								<td>${curso.id }</td>
								<td>${curso.nome }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>

<jsp:include page="../template/footer.jsp" />