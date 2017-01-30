<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card card-plain">
			<div class="header">
				<h4 class="title">Disciplinas</h4>
				<p class="category">Listagem de disciplinas cadastradas</p>
			</div>
			<div class="content table-responsive table-full-width">
				<jsp:useBean id="disciplina" class="br.com.ct.bean.DisciplinasBean"
					scope="page" />
				<table class="table table-hover">
					<thead>
						<th>ID</th>
						<th>Nome</th>
					</thead>
					<tbody>
						<c:forEach var="disciplina" items="${disciplina.listaDisciplinas }">
							<tr>
								<td>${disciplina.id }</td>
								<td>${disciplina.nome }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>

<jsp:include page="../template/footer.jsp" />