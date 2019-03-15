package com.dev.employee.controller;

import com.dev.employee.DAO.*;
import com.dev.employee.model.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.activation.FileTypeMap;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private TinhDAO tinhDAO;

    @Autowired
    private HuyenDAO huyenDAO;

    @Autowired
    private XaDAO xaDAO;

    @Autowired
    private EmployeeAddressDAO employeeAddressDAO;

    @Autowired
    private EmployeeBaseDAO employeeBaseDAO;

    private int rowperpage = 3;

    public void showInfo(int page, Model model , int rowperpage){
        List<Employee> list = employeeDAO.pagination(rowperpage,page);
        List<Employee> totalEmp = employeeDAO.getEmployeeInfo();
        model.addAttribute("employeesinfo",list);
        double totalnum = totalEmp.size();
        double total = Math.ceil(totalnum/rowperpage);
        int totalpage = (int)total;
        model.addAttribute("totalpage",totalpage);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showInfoEmployee(Model model){
        showInfo(1,model,this.rowperpage);
        return "index";
    }

    @RequestMapping(value = "/page/{number}", method = RequestMethod.GET)
    public String pagination(@PathVariable String number,Model model){
        int page = Integer.parseInt(number);
        showInfo(page,model,this.rowperpage);
        return "index";
    }

    @RequestMapping(value = "/gettinh", method = RequestMethod.GET)
    public String getAllTinh(Model model){
        List<Tinh> list = tinhDAO.getTinhInfo();
        model.addAttribute("districtinfo",list);
        return "redirect:/";
    }

    @RequestMapping(value = "/gettinhajax", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTinhAjax(Model model){
        List<Tinh> list = tinhDAO.getTinhInfo();
        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "/gethuyen", method = RequestMethod.GET)
    public String getAllHuyen(Model model){
        List<Huyen> list = huyenDAO.getHuyenInfo();
        model.addAttribute("districtinfo",list);
        return "redirect:/";
    }
    @RequestMapping(value = "/gethuyenbytinh/{id_tinh}", method = RequestMethod.GET)
    public ResponseEntity<?> getHuyenByTinh(@PathVariable String id_tinh){
        List<Huyen> list = huyenDAO.getHuyenByTinh(id_tinh);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/getxa", method = RequestMethod.GET)
    public String getAllXa(Model model){
        List<Xa> list = xaDAO.getXaInfo();
        model.addAttribute("districtinfo",list);
        return "redirect:/";
    }

    @RequestMapping(value = "/getxabyhuyen/{id_huyen}", method = RequestMethod.GET)
    public ResponseEntity<?> getXaByHuyen(@PathVariable String id_huyen){
        List<Xa> list = xaDAO.getXaByHuyen(id_huyen);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@Valid @ModelAttribute("employee") Employee emp , Errors errors , Model model){
        String empname = errors.getFieldValue("name").toString();
        String empage = errors.getFieldValue("age").toString();
        String emptinh = errors.getFieldValue("tinh").toString();
        String emphuyen = errors.getFieldValue("huyen").toString();
        String empxa = errors.getFieldValue("xa").toString();
        ArrayList<String> listMess = new ArrayList<>();
        if(empname != "" && empage != "" && emptinh != "" && emphuyen != "" && empxa != ""){
            String name = emp.getName();
            int age = emp.getAge();
            employeeBaseDAO.insertemployeeDAO(name,age);
            long id_nhanvien = employeeBaseDAO.getIdLastEmployee();
            String tinh = emp.getTinh();
            String huyen = emp.getHuyen();
            String xa = emp.getXa();
            long id_tinh = tinhDAO.getIdTinhByName(tinh);
            long id_huyen = huyenDAO.getIdHuyenByName(huyen);
            long id_xa = xaDAO.getIdXaByName(xa);
            employeeAddressDAO.insertEmployeeAddress(id_tinh,id_huyen,id_xa,id_nhanvien);

            List<Employee> list = employeeDAO.getEmployeeInfo();
            double totalnum = list.size();
            double total = Math.ceil(totalnum/rowperpage);
            int totalpage = (int)total;
            String pagenumber = String.valueOf(totalpage);
            listMess.add("success");
            listMess.add(pagenumber);
            return ResponseEntity.ok(listMess);
        }
        listMess.add("fail");
        if(empname.equals("")){
            listMess.add("name cannot be empty");
        }
        if(empage.equals("")){
            listMess.add("age cannot be empty");
        }
        if(emptinh.equals("")){
            listMess.add("tinh cannot be empty");
        }
        if(emphuyen.equals("")){
            listMess.add("huyen cannot be empty");
        }
        if(empxa.equals("")){
            listMess.add("xa cannot be empty");
        }

        return ResponseEntity.ok(listMess);
    }

    @RequestMapping(value = "/editEmp", method = RequestMethod.POST)
    public String editEmployee(@Valid @ModelAttribute("employee") Employee emp){
        Long id_nhanvien = emp.getId_nhanvien();
        String name = emp.getName();
        int age = emp.getAge();
        employeeBaseDAO.updateemployeeDAO(id_nhanvien,name,age);

        String tinh = emp.getTinh();
        String huyen = emp.getHuyen();
        String xa = emp.getXa();
        long id_tinh = tinhDAO.getIdTinhByName(tinh);
        long id_huyen = huyenDAO.getIdHuyenByName(huyen);
        long id_xa = xaDAO.getIdXaByName(xa);
        employeeAddressDAO.updateEmployeeAddress(id_tinh,id_huyen,id_xa,id_nhanvien);

        return "redirect:/page/1";
    }

    @RequestMapping(value = "/delemployee/{id}", method = RequestMethod.GET)
    public String DeleteEmployee(@PathVariable String id){
        employeeAddressDAO.deleteEmployeeAddress(id);
        employeeBaseDAO.deleteEmployee(id);
        return "redirect:/page/1";
    }

    @RequestMapping(value = "/403page", method = RequestMethod.GET)
    public String Page403(){
        return "403page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Loginpage(){

        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String Adminpage(){
        return "admin";
    }

    @RequestMapping(value = "/resources/static/img/{image}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable String image) throws IOException {
        String pathname = "src/main/resources/static/img/" + image;
        File img = new File(pathname);
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }

}
