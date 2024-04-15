package com.megayasa.Frontend.View.Asset.application;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.LoginInformationController;
import com.megayasa.Backend.Models.LoginInformation;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.ViewModels.Responses.LoginResponseVm;
import com.megayasa.Frontend.View.Asset.components.Background;
import com.megayasa.Frontend.View.Asset.forms.Dashboard;
import com.megayasa.Frontend.View.Asset.menu.FormManager;
import com.megayasa.Frontend.View.Main.Main;
import raven.popup.GlassPanePopup;

/**
 *
 * @author Ridho Multazam
 */
public class Application extends JFrame {

    LoginResponseVm loginResponseVm;
    LoginInformationController loginInformationController;
    LoginInformation loginInformation;


    public Application() {
        checkLogin();
        init();
    }

    private void init() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(UIScale.scale(new Dimension(1366, 768)));
        setLocationRelativeTo(null);
        setContentPane(new Background());
        // applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        GlassPanePopup.install(this);
        FormManager.install(this);
        FormManager.showForm(new Dashboard());
        // applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        EventQueue.invokeLater(() -> new Application().setVisible(true));
    }

    public void open() {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        EventQueue.invokeLater(() -> new Application().setVisible(true));
    }

    public void checkLogin() {
        loginInformationController = Guice.createInjector(new Injection()).getInstance(LoginInformationController.class);
        LoginInformation loginInformation1 = loginInformationController.currentLogin();
        if (loginInformation1 == null) {
            EventQueue.invokeLater(() -> this.setVisible(false));
            new Main().setVisible(true);
        }
    }
}
