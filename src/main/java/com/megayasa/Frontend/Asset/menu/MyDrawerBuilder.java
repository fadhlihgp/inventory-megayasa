package com.megayasa.Frontend.Asset.menu;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;
import javax.swing.*;

import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.LoginInformationController;
import com.megayasa.Backend.Dialogs.ConfirmationDialog;
import com.megayasa.Backend.Models.LoginInformation;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Frontend.View.Main.Main;
import raven.drawer.component.DrawerPanel;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.header.SimpleHeaderStyle;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.drawer.component.menu.SimpleMenuStyle;
import raven.drawer.component.menu.data.Item;
import raven.drawer.component.menu.data.MenuItem;
import com.megayasa.Frontend.Asset.forms.Dashboard;
import com.megayasa.Frontend.View.Setting.formAccount;
import com.megayasa.Frontend.View.Personalia.Karyawan;
import com.megayasa.Frontend.View.Personalia.Absensi;
import com.megayasa.Frontend.View.Produksi.Berita;
import com.megayasa.Frontend.View.Produksi.Penyimpanan;
import com.megayasa.Frontend.View.Produksi.Transaksi;
import raven.swing.AvatarIcon;

/**
 *
 * @author Ridho Multazam
 */
public class MyDrawerBuilder extends SimpleDrawerBuilder {

    private final ThemesChange themesChange;
    private LoginInformation loginInformation;
    private LoginInformationController loginInformationController;

    public MyDrawerBuilder() {
        themesChange = new ThemesChange();
    }

    private void initializeProperty() {
        loginInformationController = Guice.createInjector(new Injection()).getInstance(LoginInformationController.class);
        this.loginInformation = loginInformationController.currentLogin();
    }

    @Override
    public Component getFooter() {
        return themesChange;
    }

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        initializeProperty();
        AvatarIcon icon = new AvatarIcon(getClass().getResource("/image/logoME.png"), 60, 60, 999);
        icon.setBorder(2);
        return new SimpleHeaderData()
                .setIcon(icon)
                .setTitle("PT MEGAYASA ENGINEERING")
                .setDescription(loginInformation.getRole())
                .setHeaderStyle(new SimpleHeaderStyle() {

                    @Override
                    public void styleTitle(JLabel label) {
                        label.putClientProperty(FlatClientProperties.STYLE, ""
                                + "[light]foreground:#FAFAFA");
                    }

                    @Override
                    public void styleDescription(JLabel label) {
                        label.putClientProperty(FlatClientProperties.STYLE, ""
                                + "[light]foreground:#E1E1E1");
                    }
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData();
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {

//         management Menu
        MenuItem items[] = new MenuItem[]{
            new Item.Label("MAIN"),
            new Item("Dashboard", "dashboard.svg"),
            //
            new Item.Label("PERSONALIA"),
            new Item("Karyawan", "employee.svg"),
            new Item("Absensi", "presence.svg"),
            //
            new Item.Label("PRODUKSI"),
            new Item("Barang", "warehouse.svg")
            .subMenu("Penyimpanan")
            .subMenu("Transaksi"),
            new Item("Berita", "alert.svg"),
            //
            new Item.Label("PENGATURAN"),
            new Item("Akun", "userSetting.svg"),
            new Item("Keluar", "logout.svg"),
        };

//        MenuItem[] items;
//
//        if (loginInformation.getRole().equalsIgnoreCase("superadmin")) {
//            // Menu untuk superadmin
//            items = new MenuItem[]{
//                    new Item.Label("MAIN"),
//                    new Item("Dashboard3", "dashboard.svg"),
//
//                    new Item.Label("Pengaturan"),
//                    new Item("formAccount", "userSetting.svg"),
//                    new Item("Keluar", "logout.svg"),
//            };
//        } else if (loginInformation.getRole().equalsIgnoreCase("staff")) {
//            // Menu untuk staff
//            items = new MenuItem[]{
//                    new Item.Label("MAIN"),
//                    new Item("Dashboard3", "dashboard.svg"),
//                    //
//                    new Item.Label("PRODUKSI"),
//                    new Item("Barang", "warehouse.svg")
//                            .subMenu("Penyimpanan")
//                            .subMenu("Transaksi"),
//                    new Item("Berita", "alert.svg"),
//                    //
//                    new Item.Label("PENGATURAN");
//                    new Item("Keluar", "logout.svg"),
//            };
//        } else if (loginInformation.getRole().equalsIgnoreCase("personalia")) {
//            // Menu untuk personalia
//            items = new MenuItem[]{
//                    new Item.Label("MAIN"),
//                    new Item("Dashboard3", "dashboard.svg"),
//                    //
//                    new Item.Label("PERSONALIA"),
//                    new Item("Karyawan", "employee.svg"),
//                    new Item("Absensi", "presence.svg"),
//                    //
//                    new Item.Label("PENGATURAN");
//                    new Item("Keluar", "logout.svg"),
//            };
//        } else {
//            // Default menu
//            items = new MenuItem[]{
//                    new Item.Label("MAIN"),
//                    new Item("Dashboard3", "dashboard.svg"),
//                    //
//                    new Item.Label("Pengaturan"),
//                    new Item("formAccount", "userSetting.svg"),
//                    new Item("Keluar", "logout.svg"),
//            };
//        }

        SimpleMenuOption simpleMenuOption = new SimpleMenuOption() {
            @Override
            public Icon buildMenuIcon(String path, float scale) {
                FlatSVGIcon icon = new FlatSVGIcon(path, scale);
                FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
                colorFilter.add(Color.decode("#969696"), Color.decode("#FAFAFA"), Color.decode("#969696"));
                icon.setColorFilter(colorFilter);
                return icon;
            }
        };

        simpleMenuOption.setMenuStyle(new SimpleMenuStyle() {
            @Override
            public void styleMenuItem(JButton menu, int[] index) {
                menu.putClientProperty(FlatClientProperties.STYLE, ""
                        + "[light]foreground:#FAFAFA;"
                        + "arc:10");
            }

            @Override
            public void styleMenu(JComponent component) {
                component.putClientProperty(FlatClientProperties.STYLE, ""
                        + "background:$Drawer.background");
            }

            @Override
            public void styleLabel(JLabel label) {
                label.putClientProperty(FlatClientProperties.STYLE, ""
                        + "[light]foreground:darken(#FAFAFA,15%);"
                        + "[dark]foreground:darken($Label.foreground,30%)");
            }
        });

        // Action Menu
        simpleMenuOption.addMenuEvent(new MenuEvent() {
    @Override
        public void selected(MenuAction action, int[] index) {
            if (index.length == 1) {
                switch (index[0]) {
                    case 0:
                        FormManager.showForm(new Dashboard());
                        break;
                    case 1:
                        FormManager.showForm(new Karyawan());
                        break;
                    case 2:
                        FormManager.showForm(new Absensi());
                        break;
                    case 4:
                        FormManager.showForm(new Berita());
                        break;
                    case 5:
                        FormManager.showForm(new formAccount());
                        break;
                    case 6:
                        logout();
                        break;
                    default:
                        // Do nothing
                }
            } else if (index.length == 2) {
                // Memeriksa jika submenu dipilih
                switch (index[0]) {
                    case 3:
                        // Submenu dipilih
                        switch (index[1]) {
                            case 0:
                                FormManager.showForm(new Penyimpanan());
                                break;
                            case 1:
                                FormManager.showForm(new Transaksi());
                                break;
                            default:
                                // Do nothing
                        }
                        break;
                    default:
                        // Do nothing
                }
            }
        }

//            @Override
//            public void selected(MenuAction action, int[] index) {
//                if (index.length == 1) {
//                    if (loginInformation.getRole().equalsIgnoreCase("superadmin")) {
//                        switch (index[0]) {
//                            case 0:
//                                FormManager.showForm(new Dashboard3());
//                                break;
//                            case 1:
//                                FormManager.showForm(new formAccount());
//                                break;
//                            case 2:
//                                logout();
//                                break;
//                            default:
//
//                        }
//                    } else if (loginInformation.getRole().equalsIgnoreCase("staff")) {
//                        switch (index[0]) {
//                            case 0:
//                                FormManager.showForm(new Dashboard3());
//                                break;
//                            case 2:
//                                FormManager.showForm(new Berita());
//                                break;
//                            case 3:
//                                logout();
//                                break;
//                        }
//                    } else if (loginInformation.getRole().equalsIgnoreCase("personalia")) {
//                        switch (index[0]) {
//                            case 0:
//                                FormManager.showForm(new Dashboard3());
//                                break;
//                            case 1:
//                                FormManager.showForm(new Karyawan());
//                                break;
//                            case 2:
//                                FormManager.showForm(new Absensi());
//                                break;
//                            case 3:
//                                logout();
//                                break;
//                            default:
//                        }
//                    }
//                } else if (index.length == 2 && loginInformation.getRole().equalsIgnoreCase("staff")) {
//                    // Memeriksa jika submenu dipilih
//                    switch (index[0]) {
//                        case 1:
//                            // Submenu dipilih
//                            switch (index[1]) {
//                                case 0:
//                                    FormManager.showForm(new Penyimpanan());
//                                    break;
//                                case 1:
//                                    FormManager.showForm(new Transaksi());
//                                    break;
//                                default:
//                                    // Do nothing
//                            }
//                            break;
//                        default:
//                            // Do nothing
//                    }
//                }
//            }
        });

        simpleMenuOption.setMenus(items)
                        .setBaseIconPath("iconSVG")
                        .setIconScale(0.45f);
        return simpleMenuOption;
    }

    @Override
    public void build(DrawerPanel drawerPanel) {
        drawerPanel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Drawer.background");
    }

    @Override
    public int getDrawerWidth() {
        return 270;
    }

    private void logout() {
        int signout = ConfirmationDialog.otherConfirmation("Anda yakin ingin logout ?", "Signout");
        if (signout == JOptionPane.YES_NO_OPTION) {
            loginInformationController.deleteLoginInformation();
            FormManager.uninstall();
            new Main().setVisible(true);
        }
    }
}
