public class UserBeanModel {
    private int id;
    private int id_rh;
    private int id_manager;
    private String nom;
    private String prenom;
    private String role;
    private String site;
    private float soldeCP;
    private float droitAnnuelCP;
    private int compteurAbsence;

    public UserBeanModel() {

    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_rh() { return id_rh; }
    public void setId_rh(int id_rh) { this.id_rh = id_rh; }

    public int getId_manager() { return id_manager; }
    public void setId_manager(int id_manager) { this.id_manager = id_manager; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }

    public float getSoldeCP() { return soldeCP; }
    public void setSoldeCP(float soldeCP) { this.soldeCP = soldeCP; }

    public float getDroitAnnuelCP() { return droitAnnuelCP; }
    public void setDroitAnnuelCP(float droitAnnuelCP) { this.droitAnnuelCP = droitAnnuelCP; }

    public int getCompteurAbsence() { return compteurAbsence; }
    public void setCompteurAbsence(int compteurAbsence) { this.compteurAbsence = compteurAbsence; }
}
