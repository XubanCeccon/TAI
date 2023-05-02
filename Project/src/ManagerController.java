import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class LoginControleur
 */
@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 2L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerController() {
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
		List<DemandeBeanModel> demandeCpList = demandeDAOModel.findCpByManagerId(user.getId());
		List<DemandeBeanModel> demandeAbsenceList = demandeDAOModel.findAbsenceByManagerId(user.getId());

		String cp_list = "";
		for(DemandeBeanModel demande: demandeCpList) {
			UserBeanModel demande_user = userDAOModel.findUserById(demande.getId_user());

			cp_list += "<div class='d-flex justify-content-between'>" +
				"<p> " + demande_user.getPrenom() + " " + demande_user.getNom() + " &nbsp; " + "</p>" +
				"<p>" + demande.getDebut() + " à " + demande.getFin() + "</p>" +
				"<div class='d-flex justify-content-between'>" +
					"<form action='ManagerController' method='post'>" +
						"<input hidden name='demande_id' value='" + demande.getId() + "'>" +
						"<input hidden name='user_id' value='" + user.getId() + "'>" +
						"<input hidden name='valid' value='true'>" +
						"<button type='submit' class='btn btn-success' id='submit-button'>Valider</button>" +
					"</form>" +
					"<form action='ManagerController' method='post'>" +
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
					"<form action='ManagerController' method='post'>" +
						"<input hidden name='demande_id' value='" + demande.getId() + "'>" +
						"<input hidden name='user_id' value='" + user.getId() + "'>" +
						"<input hidden name='valid' value='true'>" +
						"<button type='submit' class='btn btn-success' id='submit-button'>Valider</button>" +
					"</form>" +
				"</div>" +
			"</div>";
		}

		System.out.println(absence_list);
		request.setAttribute("cp_list", cp_list);
		request.setAttribute("absence_list", absence_list);
        request.getRequestDispatcher("/Manager.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * La m?thode doPost va recevoir le form (utilisateur et mdp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int demande_id = Integer.parseInt(request.getParameter("demande_id"));
		int valid = request.getParameter("valid").equals("true") ? 1 : 0;

		DemandeDAOModel demandeDAOModel = new DemandeDAOModel();
		demandeDAOModel.validerDemande(demande_id, user_id, valid);
		doGet(request, response);
	}


}
