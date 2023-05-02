public class SiteBeanModele {
    private int id;
    private String nom;
    private String adresse;
    private String departement;
    private int codepostal;

    public SiteBeanModele() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getDepartement() { return departement; }
    public void setDepartement(String departement) { this.departement = departement; }

    public int getCodepostal() { return codepostal; }
    public void setCodepostal(int codepostal) { this.codepostal = codepostal; }
}
