package structClass.util;

public enum BTreePrintEnum {

    MIDDLE(1,"中序遍历"),

    PRE(2,"前序遍历"),

    AFTER(3,"后序遍历");

    private int index;

    private String name;

    BTreePrintEnum(int index,String name){
        this.index = index;
        this.name = name;
    }

    public static BTreePrintEnum getEnumByIndex(int index){
        for (BTreePrintEnum printEnum : BTreePrintEnum.values()){
            if (printEnum.getIndex()==index){
                return printEnum;
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
