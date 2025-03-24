package br.com.ohhigordev.controllers;


import br.com.ohhigordev.Exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new
                UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) throw new
                UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);

    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        // Aqui estamos trocando todas as ocorrências de vírgula por ponto.
        String number = strNumber.replace(",",".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+")) ;

    }


    //http://localhost:8080/math/sub/3/5
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtract(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // Método para verificar se a string é numérica usando o regex.
    private boolean isNumericSub(String strNumber){
        if(strNumber == null || strNumber.isEmpty())
            return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


    //http://localhost:8080/math/div/3/5
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double Division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        Double divisor = convertToDouble(numberTwo);

        if(divisor == 0)
            throw new UnsupportedMathOperationException("Cannot divide by zero!");

        return convertToDouble(numberOne) / divisor;
    }
    // Método para verificar se a string é numérica usando o regex.
    private boolean isNumericDiv(String strNumber){
        if(strNumber == null || strNumber.isEmpty())
            return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    //http://localhost:8080/math/mult/3/5
    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double Multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    // Método para verificar se a string é numérica usando o regex.
    private boolean isNumericMulti(String strNumber){
        if(strNumber == null || strNumber.isEmpty())
            return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    // Endpoint para raiz quadrada: http://localhost:8080/math/sqrt/9
    @RequestMapping("/sqrt/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception{
        if(!isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        Double value = convertToDouble(number);
        if(value < 0)
            throw new UnsupportedMathOperationException("Cannot calculate square root of a negative value!");

        return Math.sqrt(value);
    }

    // Endpoint para exponenciação: http://localhost:8080/math/power/2/3
    @RequestMapping("/power/{numberOne}/{numberTwo}")
    public Double power(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return Math.pow(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

}
