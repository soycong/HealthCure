package org.techtown.app.ui.checkList;

public class CheckList {
    String hitem;
    private boolean isCheck;

    public CheckList(String hitem,boolean isCheck){
        this.hitem = hitem;
        this.isCheck = isCheck;
    }

    public String getHitem() {
        return hitem;
    }

    public void setHitem(String hitem) {
        this.hitem = hitem;
    }

    public boolean isCheck() {
        return isCheck;
    }
    public void setCheck(boolean check) {
        isCheck = check;
    }
}