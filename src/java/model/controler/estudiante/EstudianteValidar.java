
package model.controler.estudiante;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import model.pojo.Estudiante;

public class EstudianteValidar implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
   
     private Pattern pattern;
     private Matcher matcher;
    
    @Override
    public boolean supports(Class<?> type) 
    {
        return Estudiante.class.isAssignableFrom(type);
       // return TuClase.class.isAssignableFrom(type);
    }
    
    private void validateSuspendido(int suspendidop, Errors errors) {
        if (suspendidop==0) {
            errors.rejectValue("suspendido","error.estudiante.suspendido","Seleccione un valor diferente");
        }
    }
    private void validateCi(int cip, Errors errors) {
       if (cip == 0 ) 
       { 
           errors.rejectValue("ci", "error.estudiante.ci", "Error en  ci"); 
       }
       
        }
    private void validateRude(int rude, Errors errors) {
       if (rude == 0 ) 
       { 
           errors.rejectValue("rude", "error.estudiante.rude", "Error en  rude"); 
       }
       
        }
    @Override
    public void validate(Object o, Errors errors) {
        
        
        Estudiante estudiante=(Estudiante)o;
        validateCi(estudiante.getCi(),errors);
        validateRude(estudiante.getRude(),errors);
        validateSuspendido(estudiante.getSuspendido(), errors);
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ci","required.nombre","El campo Ci es obligatorio");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"rude","required.nombre","El campo Rude es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
        "required.nombre", "El campo Nombre es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo",
        "required.correo", "El campo E-Mail es Obligatorio.");
        
        if (!(estudiante.getCorreo() != null && estudiante.getCorreo().isEmpty()))
        {
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(estudiante.getCorreo());
             if (!matcher.matches()) {
                errors.rejectValue("correo", "correo.incorrect",
                  "El E-Mail "+estudiante.getCorreo()+" no es válido");
               }
        }
        
        /*if(estudiante.getPais()==0)
        {
	    errors.rejectValue("pais", "required.pais","Seleccione un país");
	}*/
        
    }
    
}
