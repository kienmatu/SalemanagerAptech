/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassData;

import Entity.Employee;
import MainForm.EmployeeFrm;
import MainForm.mainApp;

/**
 *
 * @author kaisermtv
 */
public class LoginUser {
    public static Employee User;
    public static mainApp Main;
    public static EmployeeFrm Employee;
    //public static OrderFrm Order;
    public static void disposeAll()
    {
        User = new Employee();
        Main = new mainApp();
        Employee = new EmployeeFrm();
    }
}
