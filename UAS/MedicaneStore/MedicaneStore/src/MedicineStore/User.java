package MedicineStore;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends Akun{
    static Statement Stmt;
    static ResultSet Rs;
    public final String Status = "USER";

    public User(String NamaLengkap, String Username, String Email, String Password) {
        super(NamaLengkap, Username, Email, Password);
    }

    public String getStatus() {
        return Status;
    }

    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        User.Stmt = Stmt;
    }
}
