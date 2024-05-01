package com.sulimann.mercadolivrecdd.utils.validators.senhalimpa;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.sulimann.mercadolivrecdd.utils.constants.Regex;

public class SenhaLimpaValidator implements ConstraintValidator<SenhaLimpa, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtils.hasText(value)) {
            return true;
        }
        return !value.matches(Regex.SENHA_LIMPA);
    }

}
