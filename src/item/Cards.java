package item;

//����
public class Cards {
    //��ɫ
    private String color;
    //����
    private int number;
    //Ȩ��
    private int power;

    public Cards() {}

    public Cards(String color, int number,int power) {
        super();
        this.color = color;
        this.number = number;
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "color='" + getColor() + '\'' +
                ", number=" + getNumber() +
                '}';
    }
}
