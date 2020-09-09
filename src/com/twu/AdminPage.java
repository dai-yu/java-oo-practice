package com.twu;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminPage implements Page{

    static String name;
    @Override
    public void pageView(String str) {
        switch (str){
            case "1":viewList();break;
            case "2":
                System.out.println("请输入热搜内容：");
                addHotSpot();
                viewList();
                break;
            case "3":
                System.out.println("请输入超级热搜内容：");
                addSupperHotSpot();
                viewList();
                break;
            case "4":Main.setCharacter(null);break;
        }
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        AdminPage.name = name;
    }
    //查看热搜排行榜
    public void viewList(){
        Collections.sort(Main.getList());
        System.out.println("------热搜排行榜-------");
        Main.getList().stream().forEach(hotSpot-> System.out.println(String.valueOf(Main.getList().indexOf(hotSpot)+1)+".  "+hotSpot));
    }
    //添加热搜
    public void addHotSpot(){
        String hotSpotName=new Scanner(System.in).nextLine();
        int size=Main.getList().stream()
                .filter(hotSpot -> hotSpot.getContent().equals(hotSpotName))
                .collect(Collectors.toList())
                .size();
        if (size==0){
            Main.getList().add(new HotSpot(hotSpotName));
            System.out.println("添加成功！");
        }else{
            System.out.println("热搜已经存在,添加失败！");
        }
    }

    //添加超级热搜
    public void addSupperHotSpot(){
        String hotSpotName=new Scanner(System.in).nextLine();
        int size=Main.getList().stream()
                .filter(hotSpot -> hotSpot.getContent().equals(hotSpotName))
                .collect(Collectors.toList())
                .size();
        if (size==0){
            Main.getList().add(new HotSpot(hotSpotName,true));
            System.out.println("添加成功！");
        }else{
            System.out.println("热搜已经存在,添加失败！");
        }
    }
}
