package employees;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping
    public List<EmployeeDto> listEmployees(@RequestParam Optional<String> prefix) {
        return employeesService.listEmployees(prefix);
    }

    @GetMapping("/{id}")
    public EmployeeDto findEmployeesById(@PathVariable("id") long id) {
        return employeesService.findEmployeesById(id);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeDto> findEmployeesById(@PathVariable("id") long id) {
//        try {
//            return ResponseEntity.ok(employeesService.findEmployeesById(id));
//        } catch (IllegalArgumentException iea) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@Valid @RequestBody CreateEmployeeCommand command) {
        return employeesService.createEmployee(command);
    }


    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable("id") long id, @RequestBody UpdateEmployeeCommand command) {
        return employeesService.updateEmployee(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") long id) {
        employeesService.deleteEmployee(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Problem> handleNotFound(IllegalArgumentException iae) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("employees/not-found"))
                        .withTitle("Not found")
                        .withStatus(Status.NOT_FOUND)
                        .withDetail(iae.getMessage())
                        .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problem> handleValidException(MethodArgumentNotValidException mae) {
        List<Violation> violations = mae.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> new Violation(fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.toList());

        Problem problem =
                Problem.builder()
                        .withType(URI.create("employees/not-valid"))
                        .withTitle("Validation error")
                        .withStatus(Status.BAD_REQUEST)
                        .withDetail(mae.getMessage())
                        .with("violations", violations)
                        .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }

}
