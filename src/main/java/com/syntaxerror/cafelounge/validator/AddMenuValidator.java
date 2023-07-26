package com.syntaxerror.cafelounge.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.syntaxerror.cafelounge.model.MenuForm;

@Component
public class AddMenuValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MenuForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", null, "Please fill all the required fields");
        ValidationUtils.rejectIfEmpty(errors, "price", null, "Please fill all the required fields");
        ValidationUtils.rejectIfEmpty(errors, "category", null, "Please fill all the required fields");
        ValidationUtils.rejectIfEmpty(errors, "quantity", null, "Please fill all the required fields");
        ValidationUtils.rejectIfEmpty(errors, "image", null, "Please fill all the required fields");

        // MenuForm menu = (MenuForm) target;

    }

}