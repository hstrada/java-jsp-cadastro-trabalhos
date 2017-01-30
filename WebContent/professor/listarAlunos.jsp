<jsp:include page="../template/header.jsp" />


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card card-plain">
			<div class="header">
				<h4 class="title">Disciplinas -> Alunos</h4>
				<p class="category">Listagem de Alunos Por Disciplina</p>
			</div>
			<div class="content table-responsive table-full-width">
				
				<table class="table table-hover">
					<thead>
						<th>Nome</th>
						<th>Cadastrar Nota</th>
					</thead>
					<tbody>
						<c:forEach items="${alunos}" var="alunos">
							<tr>
								<td>${alunos.nome}</td>
								<td><a href="cadNotas?aluno=${alunos.id}&disciplina=${disciplina}"><i
										class="pe-7s-magic-wand"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>


<jsp:include page="../template/footer.jsp" />