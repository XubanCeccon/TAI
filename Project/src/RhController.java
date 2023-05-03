import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class LoginControleur
 */
@WebServlet("/RhController")
public class RhController extends HttpServlet {
	private static final long serialVersionUID = 2L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RhController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserBeanModel user = (UserBeanModel) session.getAttribute("user");

		DemandeDAOModel demandeDAOModel = new DemandeDAOModel();
		UserDAOModel userDAOModel = new UserDAOModel();
		List<DemandeBeanModel> demandeCpList = demandeDAOModel.findCpByRhId(user.getId());
		List<DemandeBeanModel> demandeAbsenceList = demandeDAOModel.findAbsenceByRhId(user.getId());

		String cp_list = "";
		for(DemandeBeanModel demande: demandeCpList) {
			UserBeanModel demande_user = userDAOModel.findUserById(demande.getId_user());

			cp_list += "<div class='d-flex justify-content-between'>" +
					"<p> " + demande_user.getPrenom() + " " + demande_user.getNom() + " &nbsp; " + "</p>" +
					"<p>" + demande.getDebut() + " à " + demande.getFin() + "</p>" +
					"<div class='d-flex justify-content-between'>" +
					"<form action='RhController' method='post'>" +
					"<input hidden name='formId' value='demande'>" +
					"<input hidden name='demande_id' value='" + demande.getId() + "'>" +
					"<input hidden name='user_id' value='" + user.getId() + "'>" +
					"<input hidden name='valid' value='true'>" +
					"<button type='submit' class='btn btn-success' id='submit-button'>Valider</button>" +
					"</form>" +
					"<form action='RhController' method='post'>" +
					"<input hidden name='formId' value='demande'>" +
					"<input hidden name='demande_id' value='" + demande.getId() + "'>" +
					"<input hidden name='user_id' value='" + user.getId() + "'>" +
					"<input hidden name='valid' value='false'>" +
					"<button type='submit' class='btn btn-danger' id='submit-button'>Refuser</button>" +
					"</form>" +
					"</div>" +
					"</div>";
		}

		String absence_list = "";
		for(DemandeBeanModel demande: demandeAbsenceList) {
			UserBeanModel demande_user = userDAOModel.findUserById(demande.getId_user());

			absence_list += "<div class='d-flex justify-content-between'>" +
					"<p> " + demande_user.getPrenom() + " " + demande_user.getNom() + " &nbsp; " + "</p>" +
					"<p>" + demande.getDebut() + " à " + demande.getFin() + "</p>" +
					"<div class='d-flex justify-content-between'>" +
					"<p>" + demande.getJustification() + "</p>" +
					"<form action='RhController' method='post'>" +
					"<input hidden name='formId' value='demande'>" +
					"<input hidden name='demande_id' value='" + demande.getId() + "'>" +
					"<input hidden name='user_id' value='" + user.getId() + "'>" +
					"<input hidden name='valid' value='true'>" +
					"<button type='submit' class='btn btn-success' id='submit-button'>Valider</button>" +
					"</form>" +
					"</div>" +
					"</div>";
		}

		String user_list = "";
		StringBuilder userMap = new StringBuilder("{");
		List<UserBeanModel> userList = userDAOModel.findUsersByRhId(user.getId());
		for (int i = 0; i < userList.size(); i++) {
			UserBeanModel userIndex = userList.get(i);
			userMap.append("\"").append(userIndex.getId()).append("\":[\"").append(userIndex.getSoldeCP()).append("\", \"").append(userIndex.getDroitAnnuelCP()).append("\", \"").append(userIndex.getCompteurAbsence()).append("\"]");
			if (i < userList.size() - 1) {
				userMap.append(",");
			}
			user_list += "<option value='" + userIndex.getId() + "'> " + userIndex.getPrenom() + " " + userIndex.getNom() + " </option> \r\n";
		}
		userMap.append("}");

		request.setAttribute("user_list", user_list);
		request.setAttribute("user_map", userMap);
		request.setAttribute("cp_list", cp_list);
		request.setAttribute("absence_list", absence_list);
        request.getRequestDispatcher("/RH.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * La m?thode doPost va recevoir le form (utilisateur et mdp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formId = request.getParameter("formId");
		if(formId.equals("demande")) {
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			int demande_id = Integer.parseInt(request.getParameter("demande_id"));
			int valid = request.getParameter("valid").equals("true") ? 1 : 0;

			DemandeDAOModel demandeDAOModel = new DemandeDAOModel();
			demandeDAOModel.validerDemande(demande_id, user_id, valid);
		} else {
			int user_id = Integer.parseInt(request.getParameter("selected_user"));
			float solde_disponible = Float.parseFloat(request.getParameter("solde_disponible"));
			float solde_annuelle = Float.parseFloat(request.getParameter("solde_annuelle"));
			int compteur_absence = Integer.parseInt(request.getParameter("compteur_absence"));

			UserDAOModel userDAOModel = new UserDAOModel();
			userDAOModel.updateSolde(user_id, solde_disponible, solde_annuelle, compteur_absence);
		}

		doGet(request, response);
	}


}
