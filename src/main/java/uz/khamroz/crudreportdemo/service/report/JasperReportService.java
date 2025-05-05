package uz.khamroz.crudreportdemo.service.report;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import uz.khamroz.crudreportdemo.model.User;
import uz.khamroz.crudreportdemo.repository.UserRepository;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

    private final UserRepository userRepository;

    public JasperReportService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void exportReport(HttpServletResponse response) {
       try {
           InputStream reportStream = getClass()
                   .getResourceAsStream("/report/students.jrxml");

           JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
           List<User> users = userRepository.findAll();
           JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
           Map<String, Object> parameters = new HashMap<>();
           parameters.put("ReportTitle", "My Custom Report");
           parameters.put("CompanyName", "Khamroz LLC");
           parameters.put("ReportPeriod", "Март 2025");
           parameters.put("CurrentDate", new Date());
           InputStream logoStream = getClass().getResourceAsStream("/images/logo.png");
           parameters.put("LOGO", logoStream);

           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

           JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());

       } catch (Exception e){
           e.printStackTrace();
       }
    }
}
