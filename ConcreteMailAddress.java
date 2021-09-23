package com.company;

public class ConcreteMailAddress implements MailAddressInterface {
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zip;
    private int zipdigit;


    public ConcreteMailAddress(String name, String address1, String address2, String city, String state, int zip) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddressLine1() {
        return address1;
    }

    @Override
    public String getAddressLine2() {
        return address2;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public int getZipCode() {
        return zip;
    }

    @Override
    public int getZipCodeDigit(int digit) {
        //int count =0;
        //int m = zip;
        //while (zip > 0){
        //zip = zip / 10;
        // }
        //while(m > 0){
        //zipdigit = m % 10;
        //m = m /10;
        //}
        if (digit == 0)
            zipdigit = zip % 10;
        else if(digit == 1)
            zipdigit = (zip/10)%10;
        else if(digit == 2)
            zipdigit = (zip/100)%10;
        else if(digit == 3)
            zipdigit = (zip/1000)%10;
        else
            zipdigit = (zip/10000)%10;
        return zipdigit;
    }

    @Override



    public String toString () {
            return name + "\n" + address1 + "\n" + address2 + "\n" + city + "\n" + state + "\n" + zip + "\n";
        }

}

