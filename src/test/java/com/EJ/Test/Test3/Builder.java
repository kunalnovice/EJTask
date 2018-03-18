package com.EJ.Test.Test3;

public class Builder {
    int total_records;
    public Builder(int record_count) {
        total_records=record_count;
    }
    PersonalDetails[] personalDetails;
    Customer[] customers;
    CommonFunction commonFunction = new CommonFunction();

    public void build() {
        createPersonalDetailsObject();
        createCustomerObject();
        printCustomers();
    }

    private void printCustomers() {
        for(int i=0;i<total_records;i++) {
            System.out.println("Customer No. "+(i+1)+ " Details are "
                    + customers[i].getPersonalDetails().getTitle() + " "
                    + customers[i].getPersonalDetails().getfName() + " "
                    + customers[i].getPersonalDetails().getlName());

        }
    }

    private void createCustomerObject() {
        customers = new Customer[total_records];
        for(int i=0;i<total_records;i++) {
            customers[i] = new Customer();
            customers[i].personalDetails = personalDetails[i];
        }
    }

    private void createPersonalDetailsObject() {
        personalDetails = new PersonalDetails[total_records];
        for(int i=0;i<total_records;i++) {
            personalDetails[i]=new PersonalDetails();
            personalDetails[i].setfName(commonFunction.getRandomString(5));
            personalDetails[i].title=EnumTitle.getRandomTitle().toString();
            personalDetails[i].lName=commonFunction.getRandomString(5);
        }
    }
}
