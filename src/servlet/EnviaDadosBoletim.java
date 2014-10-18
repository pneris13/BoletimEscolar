package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Boletim;
import controller.BoletimBusiness;


//@WebServlet("/EnviaDadosBoletim")
public class EnviaDadosBoletim extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

		}  

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
			
			String page = "";
			
			try{
				String cmd = request.getParameter("cmd");
				BoletimBusiness bb = new BoletimBusiness();

				if(cmd.equalsIgnoreCase("consultar")){
					Boletim consulta = null;
					String nome = "", serie = "";
					PrintWriter out = response.getWriter();

					nome = request.getParameter("nome");
					serie = request.getParameter("serie");
					
					String[] filtro = {"",""};
					int indice = 0;
					
					if(nome != "" &&  serie != ""){
						filtro[indice] = "nome";
						indice++;
						filtro[indice] = "serie";
					}
					
					consulta = bb.Consulta(nome, serie);
					if(consulta != null){
						response.setContentType("text/html");
							out.println("<html>");
							out.println("<body>");
							out.println("<h4>BOLETIM ESCOLAR</h4>");
							out.println("<table border=\"1\">");
							out.println("<tr>");
							//listar as materias
							out.println("<td></td>");
							out.println("<td></td>");
							out.println("<td></td>");
							out.println("<td></td>");
							out.println("<td></td>");
							out.println("</tr>");

							//onde imprimo as info na tela
								
								out.println("<tr>");
								out.println("<td>"+ consulta.getNome()+"</td>");
								out.println("<td>"+ consulta.getSerie()+"</td>");
//								out.println("<td>"++"</td>");
								out.println("</tr>");
							

							out.println("</table>");
							out.println("</body>");
							out.println("</html>");

							out.close();
						}

					}else{
						request.setAttribute("msg", "Não há boletim para esse Aluno e Série.");
						request.getRequestDispatcher("ConsultarNota.jsp").forward(request, response);
					}
			}catch(Exception e){
				request.setAttribute("msg", "Erro: " + e.getMessage());
				request.getRequestDispatcher(page).forward(request, response);
			}
		} 
}
