package br.com.zupacademy.andressa.casadocodigo.advice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ValorUnicoValidator implements ConstraintValidator<UniqueValue, Object> {

	String domainAtribute;
	Class<?> klass;

	@PersistenceContext
	private EntityManager em;

	@Override
	public void initialize(UniqueValue params) {
		this.domainAtribute = params.fieldName();
		this.klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = em.createQuery("select r from " + klass.getName() + " r where " + domainAtribute + " = :value");
		query.setParameter("value", value);
		List<?> results = query.getResultList();
		Assert.state(results.size() <= 1,
				"foi encontrado mais de um " + klass + "com este atributo " + domainAtribute + "igual a " + value);
		return results.isEmpty();
	}

}
