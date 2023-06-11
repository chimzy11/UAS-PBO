package MedicineStore;

public class Admin extends Akun{
    public final String Status = "Admin";

    public Admin(String NamaLengkap, String Username, String Email, String Password) {
        super(NamaLengkap, Username, Email, Password);
    }

    public String getStatus() {
        return Status;
    }    
}
