package examples.pubhub.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import examples.pubhub.dao.*;
import examples.pubhub.utilities.DAOUtilities;
import examples.pubhub.model.*;


/* ================================================================================================
 * Written By: William Bonilla
 * 
 * Servlet implementation class for TagSearchHomeServlet. This servlet will forward the request 
 * to the Tag Search. It will display all tags currently in the database and pass on that list
 * to the JSP that will present the tags to the user as buttons that the user may simply click,
 * sending the request to another servlet that will display all books associated with a tag.
 * 
 * ================================================================================================
 */
@WebServlet("/TagSearchHome")
public class TagSearchHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Hello, this is a comment for github

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TagDAO tdao = DAOUtilities.getTagDAO();
		List<Tag> tagList = tdao.getAllTags();
		
		request.setAttribute("tags", tagList);
		
		
		request.getRequestDispatcher("TagSearchHome.jsp").forward(request, response);
	}

	
}
