
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProgicielControleur
 */
@WebServlet("/ProgicielControleur")
public class ProgicielControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgicielControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getRequestDispatcher("/ProgicielVue.jsp").forward(request, response);
        
        // Test database connection
        try {
            Connection connection = ConnexionBDDModele.getConnexion();
            if (connection != null) {
                System.out.println("Database connection successful!");
                connection.close();
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * La m?thode doPost va recevoir le form (utilisateur et mdp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Check if the button was clicked
	    String action = request.getParameter("action");

	    if ("buttonClick".equals(action)) {
	        processButtonClick(request, response);
	    } else {
	        // Handle other actions or form submissions here
	    }
	}

	
	protected void processButtonClick(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Add any required logic here before navigating to the next page

	    // Forward the request to the nextPage.jsp view
	    request.getRequestDispatcher("/mdpOublieVue.jsp").forward(request, response);
	}


}
