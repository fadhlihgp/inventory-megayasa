package com.megayasa.Frontend.View.Asset.menu;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
import com.megayasa.Frontend.View.Asset.forms.Dashboard;
import com.megayasa.Frontend.View.Asset.forms.Karyawan;
import com.megayasa.Frontend.View.Asset.forms.Absensi;
import com.megayasa.Frontend.View.Asset.forms.Barang;
import com.megayasa.Frontend.View.Asset.forms.Forms;
import raven.swing.AvatarIcon;

public class MyDrawerBuilder extends SimpleDrawerBuilder {

    private final ThemesChange themesChange;

    public MyDrawerBuilder() {
        themesChange = new ThemesChange();
    }

    @Override
    public Component getFooter() {
        return themesChange;
    }

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        AvatarIcon icon = new AvatarIcon(getClass().getResource("/image/logoME.png"), 60, 60, 999);
        icon.setBorder(2);
        return new SimpleHeaderData()
                .setIcon(icon)
                .setTitle("PT MEGAYASA ENGINEERING")
                .setDescription("Admin")
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
        
        // management Menu
        MenuItem items[] = new MenuItem[]{
            new Item.Label("MAIN"),
            new Item("Dashboard", "dashboard.svg"),
            // 
            new Item.Label("PERSONALIA"),
            new Item("Karyawan", "employee.svg"),
            new Item("Absensi", "presence.svg"),
            //
            new Item.Label("PRODUKSI"),
            new Item("Barang", "warehouse.svg"),
            new Item("Forms", "file.svg"),
            //
        };

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
                case 3:
                    FormManager.showForm(new Barang());
                    break;
                case 4:
                    FormManager.showForm(new Forms());
                    break;
                default:
                    // Do nothing
            }
        }
    }
        });

        simpleMenuOption.setMenus(items)
                        .setBaseIconPath("iconMenu")
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
}
