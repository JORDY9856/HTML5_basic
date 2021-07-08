package mvc.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.guest.model.MessageDao;
import mvc.guest.model.MessageException;

public class CommandDelete implements Command {
	private String next;

	public CommandDelete( String _next ){
		next = _next;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {

		try{
				
			int message_Id = Integer.parseInt(request.getParameter("message_Id"));
			String password = request.getParameter("password");
			
			int resultCnt = MessageDao.getInstance().delete(message_Id, password);
			
			request.setAttribute("result", resultCnt);
		}catch( MessageException ex ){
			throw new CommandException("CommandDelete.java < 삭제시 > " + ex.toString() ); 
		}
		
		return next;			
	}

}
