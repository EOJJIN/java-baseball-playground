package domain;

public class Target {
    private int[] number;

    public int[] getNumber() {
        return number;
    }

    public void setNumber(){
        number = new int[3];

        number[0] = (int) (Math.random() * 9) + 1;

        number[1] = (int) (Math.random() * 9) + 1;
        while (number[0] == number[1]){
            number[1] = (int) (Math.random() * 9) + 1;
        }

        number[2] = (int) (Math.random() * 9) + 1;
        while (number[0] == number[2] || number[1] == number[2]){
            number[2] = (int) (Math.random() * 9) + 1;
        }
    }

}
