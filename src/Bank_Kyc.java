// TCS PRA Practice: Bank Account & KYC Filtering
// Description: Filters bank accounts by KYC occupation and status, and sorts matching accounts by balance in ascending order.
// Category: Core Java / OOPs

import java.util.*;
public class Bank_Kyc {
    public  static BankAccount[] findBankAccountByKYC(BankAccount[] arr,String targetOcc,String targetStat) {
        int matchCount = 0;

        for (BankAccount acc : arr) {
            if (acc.getKycDetails().getOccupation().equalsIgnoreCase(targetOcc) &&
                    acc.getKycDetails().getStatus().equalsIgnoreCase(targetStat)) {
                matchCount++;
            }
        }
        if (matchCount == 0) {
            return null;
        }
        BankAccount[] filteredArr = new BankAccount[matchCount];
        int idx = 0;
        for (BankAccount acc : arr) {
            if (acc.getKycDetails().getOccupation().equalsIgnoreCase(targetOcc) &&
                    acc.getKycDetails().getStatus().equalsIgnoreCase(targetStat)) {
                filteredArr[idx++] = acc;
            }
        }
        for (int i = 0; i < filteredArr.length - 1; i++) {
            for (int j = 0; j < filteredArr.length - i - 1; j++) {
                if (filteredArr[j].getBalance() > filteredArr[j + 1].getBalance()) {
                    BankAccount temp = filteredArr[j];
                    filteredArr[j] = filteredArr[j + 1];
                    filteredArr[j + 1] = temp;
                }
            }
        }
        return filteredArr;
    }






    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankAccount[] accounts=new BankAccount[4];

        for(int i=0;i<4;i++){
            int accNum=sc.nextInt();
            sc.nextLine();
            String holderName=sc.nextLine();
            double bal=sc.nextDouble();
            sc.nextLine();
            int kId=sc.nextInt();
            sc.nextLine();
            String stat=sc.nextLine();
            String occ=sc.nextLine();
            kyc kobj=new kyc(kId,stat,occ);
            accounts[i]=new BankAccount(accNum,holderName,bal,kobj);
        }
        String searchOccupation=sc.nextLine();
        String searchStatus=sc.nextLine();

        BankAccount[] result=findBankAccountByKYC(accounts,searchOccupation,searchStatus);
        if(result!=null){
            for(BankAccount acc:result){
                System.out.println(acc.getAccountNumber()+" "+acc.getAccountHolderName()+" "+acc.getBalance());

            }

        }
        else{
            System.out.println("No matching bank accounts found.");
        }
        sc.close();
    }

}

class kyc{
    private int kycId;
    private String status;
    private String occupation;

    public kyc(int kycId,String status,String occupation){
        this.kycId=kycId;
        this.status=status;
        this.occupation=occupation;
    }
    public int getKycId(){return kycId;}
    public String getStatus(){return status;}
    public String getOccupation(){return occupation;}
}
class BankAccount{
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private kyc kycDetails;

    public  BankAccount(int accountNumber,String accountHolderName,double balance,kyc kycDetails){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
        this.kycDetails=kycDetails;
    }
    public int getAccountNumber(){return accountNumber;}
    public String getAccountHolderName(){return accountHolderName;}
    public double getBalance(){return balance;}
    public kyc getKycDetails(){return kycDetails;}
}

