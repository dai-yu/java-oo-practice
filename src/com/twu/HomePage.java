package com.twu;

import java.util.Map;
import java.util.Scanner;

public class HomePage implements Page{

    @Override
    public void pageView(String str) {
        switch (str){
            case "1":
                System.out.println("请输入您的昵称：");
                UserPage userPage=new UserPage(new Scanner(System.in).nextLine());
                if (!Main.getUserLis().contains(userPage)){
                    Main.getUserLis().add(userPage);
                }
                Main.setCurrentUser(userPage);
                Main.setCharacter(Main.USER);
                break;
            case "2":
                System.out.println("请输入管理员名称");
                String adminName = new Scanner(System.in).nextLine();
                System.out.println("请输入密码");
                String password = new Scanner(System.in).nextLine();
                if (adminName.equals("admin") && password.equals("123456")){
                    System.out.println("管理员登陆成功！");
                }else {
                    System.out.println("账号或密码错误！");
                }
                Main.setCharacter(Main.ADMIN);
                break;
            case "3": System.exit(0);
        }
    }

    public static void welcome(){
        System.out.println("欢迎来到热搜排行榜，您是？\n1.用户\n2.管理员\n3.退出");
        Main.setCharacter(null);
    }

}
