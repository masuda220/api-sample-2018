package example.presentation;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

@ControllerAdvice
public class BasicControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }
}
