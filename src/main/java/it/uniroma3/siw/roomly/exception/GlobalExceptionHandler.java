package it.uniroma3.siw.roomly.exception;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public String gestisciIllegalArgument(IllegalArgumentException ex, Model model) {
        model.addAttribute("messaggio", ex.getMessage());
        return "errore";
    }
    @ExceptionHandler(java.util.NoSuchElementException.class)
    public String gestisciNotFound(Model model) {
        model.addAttribute("messaggio", "Elemento non trovato");
        return "errore";
    }
}