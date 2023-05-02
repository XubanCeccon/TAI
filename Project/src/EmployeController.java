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
@WebServlet("/EmployeController")
public class EmployeController extends HttpServlet {
	private static final long serialVersionUID = 2L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeController() {
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
		List<DemandeBeanModel> demandeList = demandeDAOModel.findByUserId(user.getId());

		String table_body = "";
		for(DemandeBeanModel demande: demandeList) {
			String typeDemande = demande.getTypeDemande();
			switch(demande.getTypeDemande()) {
				case "cp" -> typeDemande = "Congé Payé";
				case "absence" -> typeDemande = "Absence exceptionnelle";
			}

			String traitementManager = demande.isValidatedByManager();
			switch (traitementManager) {
				case "null" -> traitementManager = "<span style='color: grey'> Non traité </span>";
				case "1" -> traitementManager = "<span style='color: green'> Validé </span>";
				case "0" -> traitementManager = "<span style='color: red'> Refusé </span>";
			}

			String traitementRh = demande.isValidatedByRh();
			switch (traitementRh) {
				case "null" -> traitementRh = "<span style='color: grey'> Non traité </span>";
				case "1" -> traitementRh = "<span style='color: green'> Validé </span>";
				case "0" -> traitementRh = "<span style='color: red'> Refusé </span>";
			}

			table_body += "<tr>" +
				"<td>" + typeDemande + "</td>" +
				"<td>" + demande.getDebut() + "</td>" +
				"<td>" + demande.getFin() + "</td>" +
				"<td>" + traitementManager + "</td>" +
				"<td>" + traitementRh + "</td>" +
			"</tr>";
		}

		request.setAttribute("table_body", table_body);
        request.getRequestDispatcher("/Employe.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * La m?thode doPost va recevoir le form (utilisateur et mdp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("user"));
		String debut = request.getParameter("date_debut");
		String fin = request.getParameter("date_fin");
		String typeDemande = request.getParameter("typeDemande");
		String justification = request.getParameter("justification");
		
		DemandeDAOModel demandeDAOModel = new DemandeDAOModel();
		demandeDAOModel.creerDemande(id, debut, fin, typeDemande, justification);
		doGet(request, response);
	}


}
