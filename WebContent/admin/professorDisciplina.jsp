
<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="header">
				<h4 class="title">Associar Professor - Disciplina</h4>
			</div>
			<div class="content">
				<jsp:useBean id="professor" class="br.com.ct.bean.ProfessoresBean"
					scope="page" />

				<jsp:useBean id="disciplina" class="br.com.ct.bean.DisciplinasBean"
					scope="page" />

				<form action="cadProfessorDisciplina" method="post">

					<div class="row">
						<div class="col-md-12">
							<label for="curso">Selecione o Professor</label> <select
								class="form-control" id="professor" name="professor">
								<c:forEach var="professor" items="${professor.listaProfessores}">
									<option value='<c:out value="${professor.id}"/>'><c:out
											value="${professor.nome}" /></option>
								</c:forEach>
							</select>
						</div>

					</div>

					<div class="row">
						<div class="col-md-12">
							<label for="curso">Selecione o curso</label> <select
								class="form-control" id="disciplina" name="disciplina">
								<c:forEach var="disciplina"
									items="${disciplina.listaDisciplinas}">
									<option value='<c:out value="${disciplina.id}"/>'><c:out
											value="${disciplina.nome}" /></option>
								</c:forEach>
							</select>
						</div>

					</div>

					<input type="submit" class="btn btn-secondary btn-fill pull-right"
						value="Cadastrar" />
					<div class="clearfix"></div>

				</form>

				${mensagem}

			</div>
		</div>
	</div>

</div>

<jsp:include page="../template/footer.jsp" />