package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import dao.IJeuxDao;
import dao.JeuxDaoImpl;
import metier.entities.Jeux;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	IJeuxDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new JeuxDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
			request.getRequestDispatcher("Jeuxs.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			JeuxModele model= new JeuxModele();
			model.setMotCle(motCle);
			List<Jeux> prods = metier.JeuxsParMC(motCle);
			model.setJeuxs(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Jeuxs.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do") )
		{
			request.getRequestDispatcher("saisieJeux.jsp").forward(request,response);
		}
		else if (path.equals("/save.do") && request.getMethod().equals("POST"))
		{
			String nom=request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Jeux p = metier.save(new Jeux(nom,prix));
			request.setAttribute("Jeux", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/supprimer.do"))
		{
			Long id= Long.parseLong(request.getParameter("id"));
			metier.deleteJeux(id);
			response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Jeux p = metier.getJeux(id);
			request.setAttribute("Jeux", p);
			request.getRequestDispatcher("editerJeux.jsp").forward(request,response);
		}
		else if (path.equals("/update.do") )
		{
			Long id = Long.parseLong(request.getParameter("id"));
			String nom=request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Jeux p = new Jeux();
			p.setIdJeux(id);
			p.setNomJeux(nom);
			p.setPrix(prix);
			metier.updateJeux(p);
			request.setAttribute("Jeux", p);
			request.getRequestDispatcher("confirmatione.jsp").forward(request,response);
		}

		else
		{
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}