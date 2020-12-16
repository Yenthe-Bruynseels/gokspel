package model.gokstrategie;

public class ElkeWorpEven implements GokstrategieStrategy{


    public ElkeWorpEven(){

    };


    public boolean evalueerGok(int worp){
        return worp % 2 == 0;
    }
}
