package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;import java.util.*;
import java.io.*;
public class Project0Helper {
    protected ArrayList<Integer> zipList;
    long startTime, endTime;
    int outOfOrder, missingZip;
    /**
     * Constructor -- does initial setup and initialization.
     */
    public Project0Helper() {
        zipList = new ArrayList<Integer> (100);
        startTime = 0;
        endTime = 0;
        outOfOrder = 0;
        missingZip = 0;
    }

    /**
     * This checks the initial group of addresses and starts the
     * timer for the run.
     * @param mailingList  The list of addresses in their original order.
     */
    public void checkStartingOrder(MailAddressInterface mailingList[]) {
        for (int i = 0; i < mailingList.length; i++) {
            if (mailingList[i] != null) {
                zipList.add(mailingList[i].getZipCode());
            }
        }
        startTime = System.currentTimeMillis();
    }

    /**
     * This method will check for some error conditions in the data
     * such as addresses not in ascending order and mismatches in terms
     * of zip codes.
     * It also outputs the time for the sort.
     *
     * @param mailingList  The list of addresses in sorted order.
     */
    public void checkFinalOrder(MailAddressInterface mailingList[]) {
        int finalListSize = mailingList.length;

        endTime = System.currentTimeMillis();
        for (int i = 0; i < mailingList.length; i++) {
            if (mailingList[i] == null) {
                finalListSize = i;
                break;
            }
        }

        if (zipList.size() != finalListSize) {
            System.out.println("Final list size does not match initial list size!");
            System.out.println("Initial List Size = " + zipList.size());
            System.out.println("Final List Size = " + finalListSize);
        } else {
            System.out.println("Initial and Final list sizes match.");
        }

        for (int i = 1; i < finalListSize; i++) {
            if (mailingList[i - 1].getZipCode() > mailingList[i].getZipCode()) {
                System.out.println("Zip Code Out of Order");
                System.out.println("Address " + (i - 1));
                System.out.println(mailingList[i - 1]);
                System.out.println("Address " + (i));
                System.out.println(mailingList[i]);
                outOfOrder++;
            }
        }

        zipList.sort(null);
        for (int i = 0; i < finalListSize; i++) {
            if (mailingList[i].getZipCode() != zipList.get(i).intValue()) {
                System.out.println("Expecting to see zip code " + zipList.get(i).intValue());
                System.out.println("Found: ");
                System.out.println(mailingList[i]);
                missingZip++;
            }
        }

        System.out.println("Time Taken = " + (endTime - startTime) + " msec");
    }
    public static void main(String[] args) {
        MailAddressInterface[] AddressList = new ConcreteMailAddress[1000];
        Project0Helper helper = new Project0Helper();
        Scanner myscanner;
        Scanner input = new Scanner(System.in);
        System.out.println("File location: ");
        String flocation = input.nextLine();
        try {
            myscanner = new Scanner(new File(flocation));
            try {
                for (int i = 0; i < 1000; i++) {
                    String name = myscanner.nextLine();
                    String address1 = myscanner.nextLine();
                    String address2 = myscanner.nextLine();
                    String city = myscanner.nextLine();
                    String state = myscanner.nextLine();
                    int zip = myscanner.nextInt();
                    if (myscanner.hasNextLine()) {
                        myscanner.nextLine();
                    }// get rid of the rest of the line after the zip code
                    AddressList[i] = new ConcreteMailAddress(name, address1, address2, city, state, zip);
                    System.out.println(AddressList[i]);
                }
            } catch (NoSuchElementException e) {
                // end of input?
            }
            helper.checkStartingOrder(AddressList);

            helper.checkFinalOrder(AddressList);
            myscanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<List<MailAddressInterface>> AddressArray = new ArrayList<>();
        List<MailAddressInterface> firstbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(firstbin);

        List<MailAddressInterface> secondbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(secondbin);

        List<MailAddressInterface> thirdbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(thirdbin);

        List<MailAddressInterface> fourthbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(fourthbin);

        List<MailAddressInterface> fifthbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(fifthbin);

        List<MailAddressInterface> sixthbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(sixthbin);

        List<MailAddressInterface> seventhbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(seventhbin);

        List<MailAddressInterface> eighthbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(eighthbin);

        List<MailAddressInterface> ninethbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(ninethbin);

        List<MailAddressInterface> tenthbin = new ArrayList<MailAddressInterface>();
        AddressArray.add(tenthbin);
        MailAddressInterface temp[] = new MailAddressInterface[10000];

        //MailAddressInterface AddressArray[][] = new MailAddressInterface[10][10000];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < AddressList.length; j++) {
                if (AddressList[j] != null) {
                    int Digit = AddressList[j].getZipCodeDigit(i);
                    if (Digit == 0)
                        firstbin.add((ConcreteMailAddress) AddressList[j]);
                    else if (Digit == 1)
                        secondbin.add((ConcreteMailAddress) AddressList[j]);
                    else if (Digit == 2)
                        thirdbin.add((ConcreteMailAddress) AddressList[j]);
                    else if (Digit == 3)
                        fourthbin.add((ConcreteMailAddress) AddressList[j]);
                    else if (Digit == 4)
                        fifthbin.add((ConcreteMailAddress) AddressList[j]);
                    else if (Digit == 5)
                        sixthbin.add((ConcreteMailAddress) AddressList[j]);
                    else if (Digit == 6)
                        seventhbin.add((ConcreteMailAddress) AddressList[j]);
                    else if (Digit == 7)
                        eighthbin.add((ConcreteMailAddress) AddressList[j]);
                    else if (Digit == 8)
                        ninethbin.add((ConcreteMailAddress) AddressList[j]);
                    else
                        tenthbin.add((ConcreteMailAddress) AddressList[j]);
                } else {
                    break;
                }
                int index = 0;
                for (int bin = 0; bin < 10; bin++) {
                    for (int row = 0; row < AddressArray.get(bin).size(); row++) {
                        AddressList[index] = AddressArray.get(bin).get(row);
                        index++;
                    }

                }
            }
            if ( i==4) {
                break;
            }else{
                fifthbin.clear();
                secondbin.clear();
                thirdbin.clear();
                fourthbin.clear();
                fifthbin.clear();
                sixthbin.clear();
                seventhbin.clear();
                eighthbin.clear();
                ninethbin.clear();;
                tenthbin.clear();

                {

                    System.exit(0);

                }
            }
        }
    }
}

