public class DemandeBeanModel {
    private int id;
    private String typeDemande;
    private String justification;

    private boolean validationRh;
    private boolean validationManager;

    private int id_user;
    private int id_rh;
    private int id_manager;

    public DemandeBeanModel() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTypeDemande() { return typeDemande; }
    public void setTypeDemande(String typeDemande) { this.typeDemande = typeDemande; }

    public String getJustification() { return justification; }
    public void setJustification(String justification) { this.justification = justification; }

    public boolean isValidationRh() { return validationRh; }
    public void setValidationRh(boolean validationRh) { this.validationRh = validationRh; }

    public boolean isValidationManager() { return validationManager; }
    public void setValidationManager(boolean validationManager) { this.validationManager = validationManager; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public int getId_rh() { return id_rh; }
    public void setId_rh(int id_rh) { this.id_rh = id_rh; }

    public int getId_manager() { return id_manager; }
    public void setId_manager(int id_manager) { this.id_manager = id_manager; }
}
