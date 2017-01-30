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
						<th>Atividade Pr�tica</th>
						<th>Projeto 1</th>
						<th>Projeto 2</th>
					</thead>
					<tbody>
						<c:forEach items="${notas}" var="notas">
							<tr>
								<td>${notas[0]}</td>
								<td>${notas[1]}</td>
								<td>${notas[2]}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>


<jsp:include page="../template/footer.jsp" />