package com.lvck1.yys;

import com.sun.jna.platform.win32.WinDef;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class yysRobot {
    Robot robot = new Robot();

    public yysRobot() throws AWTException {
    }

    private void click(int x, int y, int offset) {
        x = x + (int) (Math.random() * (offset - 2 * offset));
        y = y + (int) (Math.random() * (offset - 2 * offset));
        robot.mouseMove(x, y);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
    }

    private void click(int x, int y) {
        click(x, y, 10);
    }


    private void duiqi(){
        List<WinDef.HWND> list = MyUser32.enumWindows("阴阳师");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            MyUser32.setWindowPos(list.get(i), 960 * i, 0, 960, 540);
        }
    }

    public void yuhun() {
        Color startColor = new Color(223, 196, 121);
        Color endColor1 = new Color(189, 168, 144);
        Color endColor2 = new Color(187, 57, 26);
        while (true) {
            //开始按钮
            if (robot.getPixelColor(1875, 505).equals(startColor)) {
                click(1875, 505);
            }
            //结束界面1
            if (robot.getPixelColor(370, 90).equals(endColor1)) {
                click(370, 90);
            }
            if (robot.getPixelColor(1330, 90).equals(endColor1)) {
                click(1330, 90);
            }
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {

            }
            //结束界面2
            if (robot.getPixelColor(510, 420).equals(endColor2)) {
                click(750, 490);
            }
            if (robot.getPixelColor(1470, 420).equals(endColor2)) {
                click(1630, 490);
            }
        }
    }

    public void yuling() throws InterruptedException {
        Color startColor = new Color(227,216,194);//855,500
        Color endColor1 = new Color(189, 168, 144);
        Color endColor2 = new Color(187, 57, 26);
        while (true) {
            //开始按钮
            if (robot.getPixelColor(855, 500).equals(startColor)) {
                click(855, 500);
            }
            //结束界面1
            if (robot.getPixelColor(372, 129).equals(endColor1)) {
                click(372, 129);
            }
            if (robot.getPixelColor(1330, 90).equals(endColor1)) {
                click(1330, 90);
            }
            Thread.sleep((long) (Math.random()*1000));
            //结束界面2
            if (robot.getPixelColor(510, 420).equals(endColor2)) {
                click(750, 490);
            }
            if (robot.getPixelColor(1470, 420).equals(endColor2)) {
                click(1630, 490);
            }
        }
    }

    public void chi() throws InterruptedException {
        Color startColor = new Color(229,219,196);//855,500
        Color endColor1 = new Color(189, 168, 144);
        Color endColor2 = new Color(187, 57, 26);
        while (true) {
            //开始按钮
            if (robot.getPixelColor(855, 500).equals(startColor)) {
                click(855, 500);
            }
            //结束界面1
            if (robot.getPixelColor(372, 129).equals(endColor1)) {
                click(372, 129);
            }
            if (robot.getPixelColor(1330, 90).equals(endColor1)) {
                click(1330, 90);
            }
            Thread.sleep((long) (Math.random()*1000));
            //结束界面2
            if (robot.getPixelColor(510, 420).equals(endColor2)) {
                click(750, 490);
            }
            if (robot.getPixelColor(1470, 420).equals(endColor2)) {
                click(1630, 490);
            }
        }
    }

    public static void main(String[] args) throws AWTException, InterruptedException {
        yysRobot yysRobot = new yysRobot();
//        yysRobot.duiqi();
        yysRobot.yuhun();
//        yysRobot.yuling();
//        yysRobot.chi();
    }
}
