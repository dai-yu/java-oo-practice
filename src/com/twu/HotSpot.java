package com.twu;

import java.util.Objects;

public class HotSpot implements Comparable{
    String content;//热搜内容
    int popularity=0;//热度
    int price = 0;//竞价价格
    int buyRank=0;//竞价购买的排名
    boolean isSuper=false;//是否是超级热搜

    //热搜排序比较规则：先比价格，再比热度
    @Override
    public int compareTo(Object o) {
        HotSpot spot=(HotSpot)o;
        int result=popularity<spot.getPopularity()? 1:(popularity==spot.getPopularity()?0:-1);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotSpot spot = (HotSpot) o;
        return getContent().equals(spot.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSuper() {
        return isSuper;
    }

    public void setSuper(boolean aSuper) {
        isSuper = aSuper;
    }

    public int getBuyRank() {
        return buyRank;
    }

    public void setBuyRank(int buyRank) {
        this.buyRank = buyRank;
    }

    public HotSpot(String content, boolean isSuper) {
        this.content = content;
        this.isSuper = isSuper;
    }
    public HotSpot() { }

    public HotSpot(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content+"  "+popularity;
    }
}
