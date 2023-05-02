import java.time.LocalDate;

public class DemandeBeanModel {
    private int id;
    private int id_typeDemande;
    private String typeDemande;
    private String justification;

    private String validationRh;
    private String validationManager;

    private int id_user;
    private int id_rh;
    private int id_manager;

    private LocalDate debut;
    private LocalDate fin;

    public DemandeBeanModel() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_typeDemande() { return id_typeDemande; }
    public void setId_typeDemande(int id_typeDemande) { this.id_typeDemande = id_typeDemande; }

    public String getTypeDemande() { return typeDemande; }
    public void setTypeDemande(String typeDemande) { this.typeDemande = typeDemande; }

    public String getJustification() { return justification; }
    public void setJustification(String justification) { this.justification = justification; }

    public String isValidatedByRh() { return validationRh; }
    public void setValidationRh(String validationRh) { this.validationRh = validationRh; }

    public String isValidatedByManager() { return validationManager; }
    public void setValidationManager(String validationManager) { this.validationManager = validationManager; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public int getId_rh() { return id_rh; }
    public void setId_rh(int id_rh) { this.id_rh = id_rh; }

    public int getId_manager() { return id_manager; }
    public void setId_manager(int id_manager) { this.id_manager = id_manager; }

    public LocalDate getDebut() { return debut; }
    public void setDebut(LocalDate debut) { this.debut = debut; }

    public LocalDate getFin() { return fin; }
    public void setFin(LocalDate fin) { this.fin = fin; }
}
