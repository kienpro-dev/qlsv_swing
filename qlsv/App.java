package qlsv_swing.qlsv;

import java.awt.EventQueue;

import qlsv_swing.qlsv.controller.LogController;
import qlsv_swing.qlsv.view.LoginView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run(){

                try {
                    String className = UIManager.getSystemLookAndFeelClassName();
                    UIManager.setLookAndFeel(className);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                LoginView view = new LoginView();
                LogController controller = new LogController(view);
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
}