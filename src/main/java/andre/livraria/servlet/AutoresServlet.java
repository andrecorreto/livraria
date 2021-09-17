package andre.livraria.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import andre.livraria.dao.AutorDao;
import andre.livraria.factory.ConnectionFactory;
import andre.livraria.modelo.Autor;

@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AutorDao dao;

	public AutoresServlet() {	
		// Solicita conexao com BD e cria Objeto DAO 
		this.dao = new AutorDao(new ConnectionFactory().getConnection());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
						
		//Envia a lista e o "ponteiro" para o jsp 
		req.setAttribute("autores", dao.listar());		
		req.getRequestDispatcher("WEB-INF/jsp/autores.jsp").forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
		// Pega variáveis do formulário (atibutos do autor) para atribuir ao Autor local
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
			
		// Converte data String para o formato LocalDate
		LocalDate dataNascimento = LocalDate.parse(
			req.getParameter("dataNascimento"), 
			DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
		String curriculo = req.getParameter("curriculo");
			
			
		// Cria Autor a partir das variáveis recebidas do formulário
		Autor autor = new Autor(
				nome, 
				email,
				dataNascimento,
				curriculo);
	
		// Adiciona Autor na tabela
		dao.cadastrar(autor);
			
		// Direciona o ponteiro para o doGet()
		resp.sendRedirect("autores");
			
		}
	
}
