<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Text input-->
<div class="form-group">
	<label class="col-md-4 control-label" for="nom">Nom</label>
	<div class="col-md-4">
		<input id="nom" name="nom" type="text" placeholder="Nom de la pizza"
			class="form-control input-md" required=""
			value="${pizza != null ? pizza.nom : ''}">

	</div>
</div>

<!-- Text input-->
<div class="form-group">
	<label class="col-md-4 control-label" for="code">Code</label>
	<div class="col-md-4">
		<input id="code" name="code" type="text"
			placeholder="Code de la pizza" class="form-control input-md"
			required="" maxlength="5" value="${pizza != null ? pizza.code : ''}"> 
			<input id="anciencode" name="anciencode" type="text" hidden=""
			value="${pizza != null ? pizza.code : ''}">
	</div>
</div>

<!-- Select Basic -->
<div class="form-group">
	<label class="col-md-4 control-label" for="categorie">Catégorie</label>
	<div class="col-md-4">
		<select id="categorie" name="categorie" class="form-control">
			<c:forEach var="categ" items="${CategoriePizza.values()}">
				<c:choose>
					<c:when test="${pizza != null && categ == pizza.categorie}">
						<option selected="selected" value="${categ}">${categ.toString()}</option>
					</c:when>
					<c:otherwise>
						<option value="${categ}">${categ.toString()}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</div>
</div>

<!-- Text input-->
<div class="form-group">
	<label class="col-md-4 control-label" for="description">Description</label>
	<div class="col-md-4">
		<input id="description" name="description" type="text"
			placeholder="Description de la pizza" class="form-control input-md"
			value="<c:if test="${(pizza != null) && (pizza.description!= null) }" >${pizza.description}</c:if>">

	</div>
</div>

<!-- Appended Input-->
<div class="form-group">
	<label class="col-md-4 control-label" for="prix">Prix</label>
	<div class="col-md-4">
		<div class="input-group">
			<input id="prix" name="prix" class="form-control"
				placeholder="Prix de la pizza" type="text" required=""
				value="${pizza != null ? pizza.prix : ''}"> <span
				class="input-group-addon">€</span>
		</div>

	</div>
</div>
<!-- File Button -->
<div class="form-group">
	<label class="col-md-4 control-label" for="image">Image</label>
	<div class="col-md-4">
		<input id="image" name="image" class="input-file" type="file"
			accept=".jpg, .png">
		<div id="list"></div>
	</div>
</div>

<!-- Button -->
<div class="form-group">
	<label class="col-md-4 control-label" for="valider"></label>
	<div class="col-md-4">
		<button id="valider" type="submit" name="valider"
			class="btn btn-success">Valider</button>
	</div>
</div>