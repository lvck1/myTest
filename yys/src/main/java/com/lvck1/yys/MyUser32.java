package com.lvck1.yys;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

import java.util.ArrayList;
import java.util.List;

public class MyUser32 {

    static final User32 user32 = User32.INSTANCE;

    public static List<WinDef.HWND> enumWindows() {
        List<WinDef.HWND> hwndList = new ArrayList<>();
        user32.EnumWindows(new WinUser.WNDENUMPROC() {
            @Override
            public boolean callback(WinDef.HWND hwnd, Pointer pointer) {
                char[] windowText = new char[512];
                user32.GetWindowText(hwnd, windowText, 512);
                String wText = Native.toString(windowText);
                System.out.println("Found window handle " + hwnd
                        + ", Text: " + wText);
                hwndList.add(hwnd);
                return true;
            }
        }, null);
        return hwndList;
    }

    public static List<WinDef.HWND> enumWindows(String title) {
        List<WinDef.HWND> hwndList = new ArrayList<>();
        user32.EnumWindows(new WinUser.WNDENUMPROC() {
            @Override
            public boolean callback(WinDef.HWND hwnd, Pointer pointer) {
                char[] windowText = new char[512];
                user32.GetWindowText(hwnd, windowText, 512);
                String wText = Native.toString(windowText);
//                System.out.println("Found window handle " + hwnd
//                        + ", Text: " + wText);
                if (wText.contains(title)) {
                    hwndList.add(hwnd);
                }
                return true;
            }
        }, null);
        return hwndList;
    }

    public static WinDef.HWND findWindow(String title) {
        return user32.FindWindow(null, title);
    }

    public static void setWindowPos(WinDef.HWND hwnd, int x, int y, int width, int height) {
        user32.SetWindowPos(hwnd, null, x, y, width, height, WinUser.SWP_FRAMECHANGED);
    }

    public static void main(String[] args) {
        List<WinDef.HWND> list = enumWindows("阴阳师");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            setWindowPos(list.get(i), 960 * i, 0, 960, 540);
        }
    }
}
