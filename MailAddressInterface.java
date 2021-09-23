package com.company;
public interface MailAddressInterface {
    public String getName();
    public String getAddressLine1();
    public String getAddressLine2();
    public String getCity();
    public String getState();
    public int getZipCode();
    public int getZipCodeDigit(int digit);
}
