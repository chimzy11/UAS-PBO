package MedicineStore;

public class Medicaine {
    private int IdObat;
    private String NamaObat;
    private String Indikasi;
    private String BentukSediaan;
    private String TanggalExp;
    private String EfekSamping;
    private String Dosis;
    private int Stok;
    private int Harga;

    public Medicaine(int IdObat, String NamaObat, String Indikasi, String BentukSediaan, String TanggalExp, String EfekSamping, String Dosis, int Stok, int Harga) {
        this.IdObat = IdObat;
        this.NamaObat = NamaObat;
        this.Indikasi = Indikasi;
        this.BentukSediaan = BentukSediaan;
        this.TanggalExp = TanggalExp;
        this.EfekSamping = EfekSamping;
        this.Dosis = Dosis;
        this.Stok = Stok;
        this.Harga = Harga;
    }
    
    public int getIdObat() {
        return IdObat;
    }

    public void setIdObat(int IdObat) {
        this.IdObat = IdObat;
    }

    public String getNamaObat() {
        return NamaObat;
    }

    public void setNamaObat(String NamaObat) {
        this.NamaObat = NamaObat;
    }

    public String getIndikasi() {
        return Indikasi;
    }

    public void setIndikasi(String Indikasi) {
        this.Indikasi = Indikasi;
    }

    public String getBentukSediaan() {
        return BentukSediaan;
    }

    public void setBentukSediaan(String BentukSediaan) {
        this.BentukSediaan = BentukSediaan;
    }
    public String getTanggalExp() {
        return TanggalExp;
    }

    public void setTanggalExp(String TanggalExp) {
        this.TanggalExp = TanggalExp;
    }

    public String getEfekSamping() {
        return EfekSamping;
    }
    public void setEfekSamping(String EfekSamping) {
        this.EfekSamping = EfekSamping;
    }

    public String getDosis() {
        return Dosis;
    }

    public void setDosis(String Dosis) {
        this.Dosis = Dosis;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int Stok) {
        this.Stok = Stok;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
    
}