import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginControleur
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		UserDAOModel userDAOModel = new UserDAOModel();
//		UserBeanModel testUser = userDAOModel.findUserByEmailAndPassword("xuban.tzu@net.estia.fr", "mdp");
//		if(testUser != null) System.out.println("TEST: " + testUser.getNom());

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * La m?thode doPost va recevoir le form (utilisateur et mdp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAOModel userDAOModel = new UserDAOModel();
		System.out.println("EMAIL: " + request.getParameter("email"));
		System.out.println("MDP: " + request.getParameter("password"));
		UserBeanModel user = userDAOModel.findUserByEmailAndPassword(request.getParameter("email"), request.getParameter("password"));

		if(user != null) {
			if(user.getRole() == null) {
				System.out.println("User has no role");
				return;
			}

			System.out.println("User " + user.getNom() + " " + user.getPrenom() + " logged in");
			request.setAttribute("user", user);
			switch (user.getRole()) {
				case "employe" -> request.getRequestDispatcher("/Employe.jsp").forward(request, response);
				case "manager" -> request.getRequestDispatcher("/dashboardManager.jsp").forward(request, response);
				case "rh" -> request.getRequestDispatcher("/dashboardHR.jsp").forward(request, response);
				default -> { }
			}
		} else {
			System.out.println("User not found");
			request.setAttribute("errorMessage", "User not found");
			doGet(request, response);
		}

//	    if ("buttonClick".equals(action)) {
//	        processButtonClick(request, response);
//	    } else {
//	        // Handle other actions or form submissions here
//	    }
	}


	protected void processButtonClick(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Add any required logic here before navigating to the next page

		// Forward the request to the nextPage.jsp view
		request.getRequestDispatcher("/mdpOublieVue.jsp").forward(request, response);
	}


}
