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
		request.setAttribute("demandeList", demandeList);

        request.getRequestDispatcher("/Employe.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * La m?thode doPost va recevoir le form (utilisateur et mdp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DemandeDAOModel demandeDAOModel = new DemandeDAOModel();
		int id = Integer.parseInt(request.getParameter("id"));
		String debut = request.getParameter("debut");
		String fin = request.getParameter("fin");
		String typeDemande = request.getParameter("typeDemande");
		String justification = request.getParameter("justification");
		demandeDAOModel.creerDemande(id, debut, fin, typeDemande, justification);

		doGet(request, response);
	}


	protected void processButtonClick(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Add any required logic here before navigating to the next page

		// Forward the request to the nextPage.jsp view
		request.getRequestDispatcher("/mdpOublieVue.jsp").forward(request, response);
	}


}
