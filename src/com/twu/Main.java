package com.twu;

import javax.sound.midi.ShortMessage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String USER="user";
    public static final String ADMIN="admin";

    //记录角色
    static String character;
    //热搜排行榜
    static List<HotSpot> list=new ArrayList<HotSpot>();
    static List<UserPage> userLis=new ArrayList<UserPage>();//用户列表
    static UserPage currentUser;//当前用户

    public static void main(String[] args) {
        String str;//输入的命令
        Page page;//角色页面
        Scanner sc=new Scanner(System.in);
        while (true){
            if(character==USER){
                System.out.println("您好，" + currentUser.getName()+ ",您可以：\n1.查看热搜排行榜\n2.给热搜事件投票\n3.购买热搜\n4.添加热搜\n5.退出");
                page=currentUser;
            }else if(character==ADMIN){
                System.out.println("您好，管理员,您可以：\n1.查看热搜排行榜\n2.添加热搜\n3.添加超级热搜\n4.退出");
                page=new AdminPage();
            }else if(character==null){
                System.out.println("欢迎来到热搜排行榜，您是？\n1.用户\n2.管理员\n3.退出");
                page=new HomePage();
            }else {
                continue;
            }
            str = sc.nextLine();
            page.pageView(str);
        }
    }


    public static String getCharacter() {
        return character;
    }

    public static void setCharacter(String character) {
        Main.character = character;
    }

    public static List<HotSpot> getList() {
        return list;
    }

    public static void setList(List<HotSpot> list) {
        Main.list = list;
    }

    public static List<UserPage> getUserLis() {
        return userLis;
    }

    public static void setUserLis(List<UserPage> userLis) {
        Main.userLis = userLis;
    }

    public static UserPage getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(UserPage currentUser) {
        Main.currentUser = currentUser;
    }

}
