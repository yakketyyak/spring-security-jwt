package com.yakketyyak.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import lombok.Data;

@Documented
@Constraint(validatedBy = NoXSSContentConstraintValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoXSSContent {

	String message() default "{noXSSContent}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

@Data
class NoXSSContentConstraintValidator implements ConstraintValidator<NoXSSContent, String> {

	private NoXSSContent noXSSContent;

	@Override
	public void initialize(NoXSSContent noSafe) {
		this.noXSSContent = noSafe;
	}

	@Override
	public boolean isValid(String safeContent, ConstraintValidatorContext cxt) {

		if (StringUtils.isBlank(safeContent)) {
			return true;
		}

		return Jsoup.isValid(safeContent, Whitelist.none());
	}

}
