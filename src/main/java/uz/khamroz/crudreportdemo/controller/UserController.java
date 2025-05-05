package uz.khamroz.crudreportdemo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import uz.khamroz.crudreportdemo.model.User;
import uz.khamroz.crudreportdemo.service.report.JasperReportService;
import uz.khamroz.crudreportdemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    private final JasperReportService jasperReportService;

    public UserController(UserService userService, JasperReportService jasperReportService) {
        this.userService = userService;
        this.jasperReportService = jasperReportService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id).orElseThrow();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id ){
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/report/download")
    public void generateReport(HttpServletResponse response){
        response.setContentType("application//pdf");
        response.setHeader("Content-Disposition", "inline; filename=report.pdf");
        jasperReportService.exportReport(response);
    }
}
