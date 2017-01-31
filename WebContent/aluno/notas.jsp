<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card card-plain">
			<div class="header">
				<h4 class="title">Aluno</h4>
				<p class="category">Listagem de Notas do Aluno</p>
			</div>
			<div class="content table-responsive table-full-width">

				<table class="table table-hover">
					<thead>
						<th>Atividade Prática</th>
						<th>Projeto 1</th>
						<th>Projeto 2</th>
						<th>Média</th>
						<th>Status</th>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${notas.atividadePratica}" /></td>
							<td><c:out value="${notas.projeto1}" /></td>
							<td><c:out value="${notas.projeto2}" /></td>
							<td><c:out value="${notas.media}" /></td>
							<td><c:out value="${notas.aprovadoDescricao}" /></td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>


<jsp:include page="../template/footer.jsp" />