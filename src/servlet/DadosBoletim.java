package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Boletim;
import controller.BoletimBusiness;

@WebServlet("/DadosBoletim")
public class DadosBoletim extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String cmd = request.getParameter("cmd");
			BoletimBusiness bb = new BoletimBusiness();

			if (cmd.equalsIgnoreCase("consultar")) {
				Boletim consulta = null;
				String nome = null, serie = null;

				nome = request.getParameter("nome");
				serie = request.getParameter("serie");

				if (nome.equals("")) {
					request.setAttribute("msg",
							"Digite um nome de aluno primeiro.");
					request.getRequestDispatcher("ConsultarNota.jsp").forward(
							request, response);
					return;
				}
				if (serie == null) {
					request.setAttribute("msg",
							"Escolha uma série primeiro.");
					request.getRequestDispatcher("ConsultarNota.jsp").forward(
							request, response);
					return;
				}
				
				PrintWriter out = response.getWriter();
				consulta = bb.Consulta(nome, serie);
				if (consulta != null) {
					response.setContentType("text/html");
					out.println("<html>");
					
					out.println("<head>");
					out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
					out.println("<title>Dados das Notas</title>");
					out.println("<link rel=\"stylesheet\" href=\"css/site.css\">");
					out.println("</head>");
					
					out.println("<body>");
					out.println("<div id=\"conteudo\">");
					out.println("<div id=\"caixa\">");
					
					out.println("<h2>Boletim Escolar</h2>");
					
					out.println("<div class=\"form\">");
					out.println("<div class=\"p\">");
					out.println(String.format("<b>Aluno:</b> %s", nome));
					out.println("</div>");
					out.println("<div class=\"p\">");
					out.println(String.format("<b>Série:</b> %sª", serie));
					out.println("</div>");
					out.println("</div>");
					
					out.println("<div class=\"p\">");
					out.println("<table class=\"grid\">");
					out.println("<tr>");
					out.println("<th>Matéria</th>");
					out.println("<th>Nota 1</th>");
					out.println("<th>Nota 2</th>");
					out.println("<th>Nota 3</th>");
					out.println("<th>Nota Final</th>");
					out.println("</tr>");

					for (String key : consulta.getNotas().keySet()) {
						String[] notas = consulta.getNotas().get(key);
						out.println("<tr>");
						out.println("<td>" + key + "</td>");
						out.println("<td>" + notas[0] + "</td>");
						out.println("<td>" + notas[1] + "</td>");
						out.println("<td>" + notas[2] + "</td>");
						out.println("<td>" + notas[3] + "</td>");
						out.println("</tr>");
					}
					out.println("</table>");
					out.println("</div>");
					
					out.println("<div class=\"p\">");
					out.println("<div class=\"botoes\">");
					out.println("<form action=\"index.jsp\">");
					out.println("<input type=\"submit\" value=\"Sair\" style=\"width: 80px;\" />");
					out.println("</form>");
					out.println("</div>");
					out.println("</div>");
					
					out.println("</div>");
					out.println("</div>");
					out.println("</body>");
					out.println("</html>");

					out.close();
				} else {
					request.setAttribute("msg",
							"Não há boletim para esse Aluno e Série.");
					request.getRequestDispatcher("ConsultarNota.jsp").forward(
							request, response);
				}
			} else {
				request.setAttribute("msg",
						"Parâmeros incorretos!");
				request.getRequestDispatcher("ConsultarNota.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", "Erro: " + e.getMessage());
			request.getRequestDispatcher("ConsultarNota.jsp").forward(request,
					response);
		}
	}
}
