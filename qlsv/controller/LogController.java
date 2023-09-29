package qlsv_swing.qlsv.controller;

import qlsv_swing.qlsv.entity.User;
import qlsv_swing.qlsv.func.UserFunc;
import qlsv_swing.qlsv.view.LoginView;
import qlsv_swing.qlsv.view.PatientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogController {
    private UserFunc userDao;
    private LoginView loginView;
    private PatientView patientView;

    public LogController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserFunc();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    /**
     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
     *
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                patientView = new PatientView();
                PatientController patientController = new PatientController(patientView);
                patientController.showPatientView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
