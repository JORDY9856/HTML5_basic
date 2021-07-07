package guest.service;

import guest.model.Message;
import guest.model.MessageDao;
import guest.model.MessageException;

import java.util.List;

public class ListMessageService {

	//-------------------------------------------------------------------
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 8;	// 한페이지당 레코드 수
	
	private static ListMessageService instance;
	
	public static ListMessageService	getInstance() throws MessageException
	{
		if( instance == null )
		{
			instance = new ListMessageService();
		}
		return instance;
	}
	
	private ListMessageService()
	{
		
	}
	
	public List <Message> getMessageList(String pNum) throws MessageException
	{
		
		int pageNum= 1;
		
		if(pNum != null) { //null에러 잡기
			pageNum= Integer.parseInt(pNum);//pNum을 숫자형으로 형변환
		}
		
		// pageNum 1	2	3	 4
		//firstRow 1	4	7	10
		//endRow   3	6	9	12
		
		int firstRow = 1+(pageNum-1)*countPerPage;
		int endRow = pageNum*countPerPage;
		
		// 전체 레코드를 검색해 온다면
		List <Message> mList = MessageDao.getInstance().selectList(firstRow, endRow);			
		return mList;
	}
	
	
	public int getTotalCount() throws MessageException{
			//db에서 실제 레코드 수를 얻어오기
			totalRecCount = MessageDao.getInstance().getTotalCount();

			//전체 페이지 수 구하기(pageTotalCount)
			
			///3 =
			//
			if(totalRecCount%3==0) {
				pageTotalCount= totalRecCount/countPerPage;
			}
	 
			else {
				pageTotalCount = (totalRecCount/countPerPage)+1;
			}
			
			return pageTotalCount;
			
	 }
	
	
}
