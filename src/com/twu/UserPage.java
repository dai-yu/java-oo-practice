package com.twu;

import java.util.*;
import java.util.stream.Collectors;

public class  UserPage implements Page{
    String name;
    int ticket=10;

    @Override
    public void pageView(String str) {
        switch (str) {
            case "1":viewList();break;
            case "2":
                System.out.println("请输入你要投票的热搜名称：");
                HotSpot currentHotSpot = getCurrentHotSpot();
                System.out.println("请输入你要投票的热搜票数:");
                int ticket = Integer.parseInt(new Scanner(System.in).nextLine());
                vote(currentHotSpot,ticket);
                viewList();
                break;
            case "3":
                System.out.println("请输入你要购买的热搜名称：");
                HotSpot currentBuyHotSpot = getCurrentHotSpot();
                System.out.println("请输入你要购买热搜的金额:");
                int price = Integer.parseInt(new Scanner(System.in).nextLine());
                buyHotSpot(currentBuyHotSpot,price);
                viewList();
                break;
            case "4":
                System.out.println("请输入热搜内容：");
                addHotSpot();
                viewList();
                break;
            case "5":
                Main.setCharacter(null);
                break;
        }

    }

    //查看热搜排行榜
    public void viewList(){
        Collections.sort(Main.getList());
//        Collections.reverse(Main.getList());
        System.out.println("------热搜排行榜-------");
        Main.getList().stream().forEach(hotSpot-> System.out.println(String.valueOf(Main.getList().indexOf(hotSpot)+1)+".  "+hotSpot));
    }

    //给热搜事件投票
    public void vote(HotSpot spot,int ticket){
        if(ticket>10 || ticket<=0 || spot==null || this.ticket<ticket){
            System.out.println("投票失败！");
        }else{
            spot.setPopularity((spot.isSuper()?spot.getPopularity()+ticket*2:spot.getPopularity()+ticket));
            this.ticket=this.ticket-ticket<=0?0:this.ticket-ticket;
            System.out.println("投票成功！");
        }
    }

    //购买热搜
    public void buyHotSpot(HotSpot spot,int money){
        if (money<=0 || spot==null || money<spot.getPrice()){
            System.out.println("购买失败！");
        }else{
            spot.setPrice(money);
        }
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


    //获取当前热搜
    public HotSpot getCurrentHotSpot(){
        String hotSpotName=new Scanner(System.in).nextLine();
        return Main.getList().stream()
                .filter(hotSpot -> hotSpot.getContent().equals(hotSpotName))
                .collect(Collectors.toList())
                .get(0);
    }



    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPage userPage = (UserPage) o;
        return getName().equals(userPage.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public UserPage(String name) {
        this.name = name;
    }
    public UserPage() {
    }
}
